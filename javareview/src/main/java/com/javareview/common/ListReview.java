package com.javareview.common;

import java.util.List;

/**
 * Created by lcyanxi on 2017/7/18.
 */
public class ListReview {
    //ArrayList是基于动态数组实现的，LinkedList是基于链表实现的 vector采用数组实现，用了synchronized方法-线程安全.
    //对于读取数据ArrayList优于LinkdeList,因为LinkdeList要移动指针
    //对于添加和删除数据LinkdeList要优于ArrayList, 因为后者要移动数据
    static final int N = 10000000;

    public static long timeList(List list) {
        long startTime = System.currentTimeMillis();
        Object object = new Object();
        for (int i = 0; i < N; i++) {
            list.add(i, object);
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long readList(List list) {
        long startTime = System.currentTimeMillis();
        int j = list.size();
        for (int i = 0; i < j; i++) {

        }
        return System.currentTimeMillis()-startTime;
    }

    public static List addList(List list){
        Object object=new Object();
        for (int i=0;i<N;i++){
            list.add(object);
        }
        return list;
    }

}
