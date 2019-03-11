package com.javase.learn.design.factory.nomal.impl.car;


import com.javase.learn.design.factory.nomal.inter.ICar;

public class BaoMaCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("得到宝马汽车！");
    }
}
