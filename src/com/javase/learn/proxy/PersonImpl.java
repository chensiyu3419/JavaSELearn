package com.javase.learn.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/7/1
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public class PersonImpl implements IPerson{

    @Override
    public String say() {
        System.out.println("说话！");
        return "说就说！";
    }
}
