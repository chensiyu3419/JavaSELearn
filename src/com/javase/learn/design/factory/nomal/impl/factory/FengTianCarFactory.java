package com.javase.learn.design.factory.nomal.impl.factory;

import com.javase.learn.design.factory.nomal.impl.car.FengTianCar;
import com.javase.learn.design.factory.nomal.inter.ICar;
import com.javase.learn.design.factory.nomal.inter.ICarFactory;

public class FengTianCarFactory implements ICarFactory {
    @Override
    public ICar createCar() {
        return new FengTianCar();
    }
}
