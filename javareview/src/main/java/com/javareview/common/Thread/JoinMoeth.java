package com.javareview.common.Thread;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class JoinMoeth {
    /**
     * join —— 一个线程等待另一个线程完成才继续执行。
     * 如A线程线程执行体中调用B线程的join()方法，则A线程被阻塞，直到B线程执行完为止，A才能得以继续执行。
     */
    public static void main(String args[]){
        Runnable runnable=new MyRunnableJoin();
        Thread thread =new Thread(runnable);

        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"------"+i);
            if (i==30){
                thread.start();

                try {
                    //调用join（）主线程等待thread线程执行完才执行
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
class MyRunnableJoin implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
         System.out.println(Thread.currentThread().getName()+"*******"+i);
        }
    }
}
