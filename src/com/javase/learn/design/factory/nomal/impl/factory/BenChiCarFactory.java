package com.javase.learn.design.factory.nomal.impl.factory;

import com.javase.learn.design.factory.nomal.impl.car.BenChiCar;
import com.javase.learn.design.factory.nomal.inter.ICar;
import com.javase.learn.design.factory.nomal.inter.ICarFactory;

public class BenChiCarFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new BenChiCar();
    }
}
