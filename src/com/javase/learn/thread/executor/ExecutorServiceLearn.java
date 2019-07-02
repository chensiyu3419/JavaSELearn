package com.javase.learn.thread.executor;

import com.javase.learn.domain.CallableDomain;
import com.javase.learn.domain.Person;
import com.javase.learn.domain.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/25
 * Time: 下午9:03
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorServiceLearn {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors(), 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        List<CallableDomain> callableDomainList = new ArrayList<>();
        for(int i = 0; i<Runtime.getRuntime().availableProcessors(); i++){
            CallableDomain callableDomain = new CallableDomain();
            callableDomainList.add(callableDomain);
        }

        List<Future<Result>> futureList = pool.invokeAll(callableDomainList);

        System.out.println(Thread.currentThread().getName() + "：所有人跳完了，来执行下一个动作！");

        pool.shutdown();
    }
}
