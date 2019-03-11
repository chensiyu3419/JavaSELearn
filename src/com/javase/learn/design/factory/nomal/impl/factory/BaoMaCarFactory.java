package com.javase.learn.design.factory.nomal.impl.factory;

import com.javase.learn.design.factory.nomal.impl.car.BaoMaCar;
import com.javase.learn.design.factory.nomal.inter.ICar;
import com.javase.learn.design.factory.nomal.inter.ICarFactory;

public class BaoMaCarFactory implements ICarFactory {

    @Override
    public ICar createCar() {
        return new BaoMaCar();
    }
}
