package com.javase.learn.design.factory.simple.factory;

import com.javase.learn.design.factory.constant.CarTypeEnum;
import com.javase.learn.design.factory.simple.impl.BaoMaCar;
import com.javase.learn.design.factory.simple.impl.BenChiCar;
import com.javase.learn.design.factory.simple.impl.FengTianCar;
import com.javase.learn.design.factory.simple.inter.ICar;

/**
 * 简单工厂模式
 *
 * 创建类的操作放在工厂类里，根据传入的参数来选择要创建的类型。
 */
public class SimpleFactory {

    public ICar createCar(CarTypeEnum carTypeEnum){
        if(carTypeEnum.getType() == CarTypeEnum.FENG_TIAN.getType()){
            return new FengTianCar();
        } else if(carTypeEnum.getType() == CarTypeEnum.BAO_MA.getType()){
            return new BaoMaCar();
        } else if(carTypeEnum.getType() == CarTypeEnum.BEN_CHI.getType()){
            return new BenChiCar();
        }

        return null;
    }
}
