package com.javase.learn.domain;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/25
 * Time: 下午9:03
 * To change this template use File | Settings | File Templates.
 */
public class CallableDomain implements Callable<Result> {

    @Override
    public Result call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "跳的嗨……");

        Result<Boolean> result = new Result<>();
        result.setSuccess(true);
        result.setObj(true);

        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "跳完!");
        return result;
    }
}
