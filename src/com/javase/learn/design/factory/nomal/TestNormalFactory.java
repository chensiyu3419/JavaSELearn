package com.javase.learn.design.factory.nomal;

import com.javase.learn.design.factory.nomal.inter.ICar;
import com.javase.learn.design.factory.nomal.inter.ICarFactory;

public class TestNormalFactory {

    public static void main(String[] args) {
        ICar car;

        try {
            /**
             * 此处的包名可以卸载配置文件里，也可以用spring的方式注入
             */
            ICarFactory carFactory = (ICarFactory) Class.forName("com.javase.learn.design.factory.nomal.impl.factory.BenChiCarFactory").newInstance();
            car = carFactory.createCar();
            car.getCar();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
