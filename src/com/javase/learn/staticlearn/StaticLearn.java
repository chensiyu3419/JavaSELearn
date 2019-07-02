package com.javase.learn.staticlearn;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/24
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class StaticLearn {

    public static StaticLearn getStaticLearn(){
        System.out.println("static方法执行");
        return new StaticLearn();
    }

    public static void main(String[] args) {

    }
}
