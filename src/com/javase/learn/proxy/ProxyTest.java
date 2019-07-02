package com.javase.learn.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/7/1
 * Time: 下午6:34
 * To change this template use File | Settings | File Templates.
 */
public class ProxyTest {

    public static void main(String[] args) {
        IPerson person = new PersonImpl();
        PersonProxy personProxy = new PersonProxy(person, new NormalHandler(person));
        IPerson proxy = personProxy.createProxy();
        String speak = proxy.say();
        System.out.println(speak);
    }
}
