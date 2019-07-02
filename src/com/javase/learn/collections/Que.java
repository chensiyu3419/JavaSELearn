package com.javase.learn.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/7/1
 * Time: 下午8:06
 * To change this template use File | Settings | File Templates.
 */
public class Que {

    public static void main(String[] args) {
        try {
            BlockingQueue array = new ArrayBlockingQueue(5);
            BlockingQueue linked = new LinkedBlockingQueue();

            for(int i=0; i<6; i++){
                boolean flag = array.offer(i);
                if(!flag){
                    System.out.println(i + "值没有塞进去！");
                }
            }

            for(Object o : array){
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
