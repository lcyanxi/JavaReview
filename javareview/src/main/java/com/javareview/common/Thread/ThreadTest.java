package com.javareview.common.Thread;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class ThreadTest {
    public static void main(String args[]){
        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"-------"+i);
            if (i==30){
                System.out.println("--------------------------");
                //创建两个新线程，thread 此线程进入新建状态
                Thread thread=new MyThread();
                Thread thread1=new MyThread();

                //调用start方法线程进入就绪状态
                thread.start();
                thread1.start();

                //线程不会马上执行，等待cpu调度
            }
        }
    }

}
class  MyThread extends Thread{
    private int i=0;

    @Override
    public void run() {

        for (i =0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"********"+i);
        }
    }
}