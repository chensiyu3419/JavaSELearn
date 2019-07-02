package com.javase.learn.reflection;

import com.javase.learn.domain.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/28
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionLearn {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CountDownLatch latch = new CountDownLatch(1);
        Person person = new Person(latch);
        Class<Person> classPerson = Person.class;
        Field[] fields = classPerson.getDeclaredFields();
        Method[] methods = classPerson.getMethods();

        for(Field field : fields){
            System.out.println(field.getName());
        }

        for(Method method : methods){
            if("jump".equals(method.getName())){
                method.invoke(person);
            }
        }
    }
}
