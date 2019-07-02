package com.javase.learn.domain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/24
 * Time: 下午9:02
 * To change this template use File | Settings | File Templates.
 */
public class RunnableDomain implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public RunnableDomain(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行……");

        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "执行完毕，等待其他线程执行！");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "线程写入完毕，继续执行其他任务！");
    }
}
