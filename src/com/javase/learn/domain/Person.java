package com.javase.learn.domain;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/26
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Runnable {

    private CountDownLatch countDownLatch;

    public Person(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        this.jump();
    }

    public void jump(){
        System.out.println(Thread.currentThread().getName() + "正在跳……");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
