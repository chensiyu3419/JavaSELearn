package com.javase.learn.design.factory.nomal.impl.car;


import com.javase.learn.design.factory.nomal.inter.ICar;

public class FengTianCar implements ICar {

    @Override
    public void getCar() {
        System.out.println("得到丰田汽车！");
    }
}
