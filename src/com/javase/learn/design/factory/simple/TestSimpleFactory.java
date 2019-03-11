package com.javase.learn.design.factory.simple;

import com.javase.learn.design.factory.constant.CarTypeEnum;
import com.javase.learn.design.factory.simple.factory.SimpleFactory;
import com.javase.learn.design.factory.simple.inter.ICar;

public class TestSimpleFactory {

    public static void main(String[] args) {

        SimpleFactory simpleCarFactory = new SimpleFactory();

        ICar car  = simpleCarFactory.createCar(CarTypeEnum.BAO_MA);

        car.getCar();
    }
}
