package com.javareview.common;

import java.io.*;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class SerializableReview implements Serializable {
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