package com.javareview.common.Thread;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class RunnableTest {
    public static void main(String args[]){
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"----"+i);

            if (i==30){
                System.out.println("创建多线程对象");
                //创建一个runnable实现类的对象
                Runnable runnable=new MyRunnable();
                //将runnable作为Thread target 创建新的线程对象
                Thread thread=new Thread(runnable);
                //线程执行体是MyThread类中的run()方法，Thread类本身也是实现了Runnable接口
                Thread thread1=new Thread(runnable);


                //调用start方法将线程进入就绪状态
                thread.start();
                thread1.start();
            }
        }
    }

}
class MyRunnable implements Runnable{

    private int i =0;
    public void run() {
        for (i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"******"+i);
        }
    }
}

