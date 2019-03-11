package com.javase.learn.thread.vola;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字
 *
 * 本类主要测试volatile关键字的原子性
 *
 * 要想线程安全，保证三个原则
 * 1.原子性
 * 2.可见性
 * 3.有序性
 *
 * volatile修饰的字段直接从主存拿取变量，从而保证了可见性。
 * volatile修饰的字段可以禁止指令重排序，保证一定程度上的有序性。
 *
 * 但是volatile不能保证原子性
 */
public class VolatileLearn {

    //非原子性int
    public volatile int count = 0;
    //原子性int
    public volatile AtomicInteger atomicCount = new AtomicInteger(0);

    public void add(){
        count++;
    }

    public void atomicAdd(){
        atomicCount.getAndIncrement();
    }

    /**
     * 非原子性的测试方法，结果总是小于10000，是因为count++这个动作非原子性。
     */
    public static void noAtomicMethord(){
        final VolatileLearn volatileLearn = new VolatileLearn();

        for(int i=0; i<10; i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for(int j=0; j<1000; j++){
                        volatileLearn.add();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(volatileLearn.count);
    }

    /**
     * 原子性的测试方法，结果等于10000
     */
    public static void atomicMethord(){
        final VolatileLearn volatileLearn = new VolatileLearn();

        for(int i=0; i<10; i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for(int j=0; j<1000; j++){
                        volatileLearn.atomicAdd();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(volatileLearn.atomicCount);
    }

    public static void main(String[] args) {
        //非原子性
//        noAtomicMethord();
        //原子性
        atomicMethord();
    }
}
