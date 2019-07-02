package com.javase.learn.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/24
 * Time: 下午8:19
 * To change this template use File | Settings | File Templates.
 */
public class CountDownLatchLearn {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            @Override
            public void run() {
                System.out.println("线程1执行");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("线程2执行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }.start();

        System.out.println("主线程等待两个子线程执行完毕！");
        latch.await();
        System.out.println("子线程执行完毕，主线程开始执行！");
        System.out.println("主线程执行完毕！");
    }
}
