package jmm;

/**
 * created by wuliqing
 */
public class VolatileTest {
    private static volatile int race = 0;

    private static final int THREAD_COUNT = 200;
    private static void increase(){
        race++;
    }

    public static void main(String[] args){
        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i=0;i<THREAD_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        if(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(race);
    }
}
