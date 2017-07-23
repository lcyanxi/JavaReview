package com.javareview.common;
/**
 * Created by lcyanxi on 2017/7/17.
 */
public class StiringReview {

    //String、 StringBuilder、StringBuffer的区别
    //从效率和安全角度来考虑
    //效率 StringBuilder > StringBuffer > String
    //安全 StringBuffer为synchronized线性安全  维持同步锁  StringBudilder单线程用得多



    public static void main(String args []){
        long time=System.currentTimeMillis();
        String str=null;
        for (int i=0;i<100000;i++){
            str=str+i +",";
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    public void testStringBuffer(){
        long time=System.currentTimeMillis();
         StringBuffer str=null;
        for (int i=0;i<100000;i++){
            str=str.append(i+",");
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    public void testStringBuilder(){
        long time=System.currentTimeMillis();
        StringBuilder str=null;
        for (int i=0;i<100000;i++){
            str=str.append(i+",");
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
