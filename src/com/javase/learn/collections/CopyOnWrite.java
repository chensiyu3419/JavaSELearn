package com.javase.learn.collections;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chensiyu3
 * Date: 2019/6/24
 * Time: 下午7:23
 * To change this template use File | Settings | File Templates.
 */
public class CopyOnWrite {

    private static CopyOnWriteArrayList<Integer> arrayList;

    public static void main(String[] args) {
        arrayList = new CopyOnWriteArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        for(Integer integer : arrayList){
            if(2 == integer){
                arrayList.remove(integer);
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("arrayList中的数据为：[");
        for(int i = 0; i < arrayList.size(); i++){
            sb.append(i);
            if(arrayList.size() > (i+1)){
                sb.append(",");
            }
        }

        sb.append("]");

        System.out.println(sb.toString());
    }
}
