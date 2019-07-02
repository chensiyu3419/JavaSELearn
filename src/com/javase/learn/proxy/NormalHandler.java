package com.javase.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/7/1
 * Time: 下午5:56
 * To change this template use File | Settings | File Templates.
 */
public class NormalHandler implements InvocationHandler {

    private Object target;

    public NormalHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Now Time:" + sdf.format(new Date()));
        return method.invoke(target, args);
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
