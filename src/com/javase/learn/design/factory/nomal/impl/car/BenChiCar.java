package com.javase.learn.design.factory.nomal.impl.car;


import com.javase.learn.design.factory.nomal.inter.ICar;

public class BenChiCar implements ICar {
    @Override
    public void getCar() {
        System.out.println("得到奔驰汽车！");
    }
}
