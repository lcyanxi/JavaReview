package com.javareview.common;

import java.io.*;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class SerializableReview implements Serializable {
    /**
     * transient用于对象序列化   volatile用于线程同步
     * transient是类型修饰符，只能修饰字段，在对象序列化过程中，标记为transient的变量不会被序列化
     *
     * volatile也是类型修饰符，只能修饰变量，volatile修饰的成员变量在每次被线程访问时，都强迫从内存中重读成员变量的值。
     * java内存机制：
     * Java使用一个主内存来保存变量当前值，而每个线程则有其独立的工作内存。线程访问变量的时候会将变量的值拷贝到
     * 自己的工作内存中，这样，当线程对自己工作内存中的变量进行操作之后，就造成了工作内存中的变量拷贝的值与
     * 主内存中的变量值不同。
     * java规范：
     * 为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，而且只当线程进入
     * 或者离开同步代码块时才与共享成员变量的原始值对比。
     * 在两个或者更多的线程访问的成员变量上使用volatile。当要访问的变量已在synchronized代码块中，或者为常量时，不必使用。
     *
     */
    private static final long serialVersionUID = -1806336985091534784L;
    private String name;


    public SerializableReview(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}
class SerializableReviewSerializable {
    public static  void main(String args[]) throws Exception{
      SerializableReview serializableReview=new SerializableReview("jason");
      //对象序列化成字节流
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D:\\test\\file1.txt"));
        outputStream.writeObject(serializableReview);
        outputStream.close();


        //字节流反序列化成对象

        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("D:\\test\\file1.txt"));
        SerializableReview  serializableReview1=(SerializableReview)inputStream.readObject();
        inputStream.close();

        System.out.println(serializableReview.getName()+"____"+serializableReview1.getName());
        assert serializableReview.getName().equals(serializableReview1.getName());
    }
}