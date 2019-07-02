package com.javase.learn.thread.threadLocal;

import com.javase.learn.domain.Result;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/26
 * Time: 下午9:00
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLocalLearn {

    private static Result result = new Result();

    private static ThreadLocal<Result> threadLocal;

    public static void main(String[] args) throws InterruptedException {

        threadLocal = new ThreadLocal<>();

        result.setSuccess(true);

        threadLocal.set(result);

        new Thread(){

            @Override
            public void run() {
                result.setSuccess(false);
            }
        }.start();

        Thread.sleep(100);

        result = threadLocal.get();

        System.out.println(result.isSuccess());
    }
}
