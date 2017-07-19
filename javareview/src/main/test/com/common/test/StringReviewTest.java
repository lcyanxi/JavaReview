package com.common.test;

import org.junit.Test;

/**
 * Created by lcyanxi on 2017/7/17.
 */
public class StringReviewTest {
    //String、 StringBuilder、StringBuffer的区别
    //从效率和安全角度来考虑
    //效率 StringBuilder > StringBuffer > String
    //安全 StringBuffer为synchronized线性安全  维持同步锁  StringBudilder单线程用得多
    public  void testString(){
        long time=System.currentTimeMillis();
        String str=null;
        for (int i=0;i<100000;i++){
            str=str+i +",";
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    public void testStringBuffer(){
        long time=System.currentTimeMillis();
        StringBuffer str=new StringBuffer();
        for (int i=0;i<100000;i++){
            str=str.append(i+",");
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    public void testStringBuilder(){
        long time=System.currentTimeMillis();
        StringBuilder str=new StringBuilder();
        for (int i=0;i<100000;i++){
            str=str.append(i+",");
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    public void test(){
        testString();
        testStringBuffer();
        testStringBuilder();
    }
}
