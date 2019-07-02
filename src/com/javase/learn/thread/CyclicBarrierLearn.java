package com.javase.learn.thread;

import com.javase.learn.domain.RunnableDomain;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/24
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class CyclicBarrierLearn {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        for(int i=0; i < 4; i++){
            new Thread(new RunnableDomain(cyclicBarrier)).start();
        }
    }
}
