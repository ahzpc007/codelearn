package com.study.atm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuliqing
 */
public class Demo {
    private static AtomicInteger count = new AtomicInteger(0);
    public int increment(int i) {
        return count.incrementAndGet();
    }
    public int value(int i) {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        while (true) {
            demo.increment(0);
            System.out.println("counter: " + demo.value(0));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
