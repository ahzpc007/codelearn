package com.study.atm.zk;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wuliqing
 * @data 2018-07-16
 */
public class LockTest {
    private String zkQurom = "localhost:2181";

    private String lockName = "/root_lock";

    private String lockZnode = null;

    private ZooKeeper zk;

    private CountDownLatch countDownLatch;

    private int waitTimeout = 30000;

    public LockTest(){
        try {
            // 创建一个与服务器的连接
            zk = new ZooKeeper(zkQurom, 6000, new Watcher() {
                // 监控所有被触发的事件
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("Receive event "+watchedEvent);
                    if(Event.KeeperState.SyncConnected == watchedEvent.getState())
                        System.out.println("connection is established...");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ensureRootPath() throws InterruptedException {
        try {
            //判断path是否存在
            if (zk.exists(lockName,true)==null){
                // 创建一个目录节点
                zk.create(lockName,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取锁
     * @return
     * @throws InterruptedException
     */
    public boolean lock() throws InterruptedException {
        String path = null;
        ensureRootPath();
        try {
            path = zk.create(lockName + "/mylock_", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            lockZnode = path;
            System.out.println(Thread.currentThread().getName() + ":" + lockZnode + " 已经创建");
            List<String> lockPaths = zk.getChildren(lockName,false);
            Collections.sort(lockPaths);
            System.out.println(Thread.currentThread().getName() + ",lockPaths:" + lockPaths);
            if (path.equals(lockName + "/" + lockPaths.get(0))) {
                return true;
            }
            return waitForLock(lockPaths,path);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     *
     */
    private boolean waitForLock(List<String> lockPaths,String path) throws InterruptedException, KeeperException {
        String prevNode = path.substring(path.lastIndexOf("/") + 1);
        String watchNode = lockPaths.get(Collections.binarySearch(lockPaths, prevNode) - 1);
        Stat stat = zk.exists(lockName + "/" + watchNode, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType() == Event.EventType.NodeDeleted){
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        });
        if(stat != null){
            System.out.println(Thread.currentThread().getName() + "等待锁 " + lockName + "/" + watchNode);
            this.countDownLatch = new CountDownLatch(1);
            // 计数等待，若等到前一个节点消失，则precess中进行countDown，停止等待，获取锁
            this.countDownLatch.await(waitTimeout, TimeUnit.MILLISECONDS);
            this.countDownLatch = null;
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 等到了锁");
        }
        return true;
    }
    /**
     * 释放锁
     */
    public void unlock(){
        try {
            //version 为 -1 可以匹配任何版本，也就删除了这个目录节点所有数据
            zk.delete(lockZnode,-1);
            System.out.println(Thread.currentThread().getName() +  "：release Lock..." + lockZnode);
            lockZnode = null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0;i<4;i++){
            service.execute(()-> {
                LockTest test = new LockTest();
                try {
                    test.lock();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.unlock();
            });
        }
        service.shutdown();
    }


}
