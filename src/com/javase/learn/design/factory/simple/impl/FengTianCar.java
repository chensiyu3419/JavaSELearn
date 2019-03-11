package com.javase.learn.design.factory.simple.impl;

import com.javase.learn.design.factory.simple.inter.ICar;

public class FengTianCar implements ICar {

    @Override
    public void getCar() {
        System.out.println("得到丰田汽车！");
    }
}
