package com.javase.learn.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/7/1
 * Time: 下午6:19
 * To change this template use File | Settings | File Templates.
 */
public class PersonProxy {

    private IPerson person;

    private InvocationHandler invocationHandler;

    public PersonProxy(IPerson person, InvocationHandler invocationHandler) {
        this.person = person;
        this.invocationHandler = invocationHandler;
    }

    public IPerson createProxy(){
        return (IPerson)Proxy.newProxyInstance(IPerson.class.getClassLoader(), person.getClass().getInterfaces(), invocationHandler);
    }
}
