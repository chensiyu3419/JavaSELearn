package com.javase.learn.design.factory.simple.impl;

import com.javase.learn.design.factory.simple.inter.ICar;

public class BenChiCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("得到奔驰汽车！");
    }
}
