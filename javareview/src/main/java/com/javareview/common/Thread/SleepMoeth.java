package com.javareview.common.Thread;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class SleepMoeth {
    public static void main(String args[]){
        Thread thread=new MyThreadSleep();
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"----"+i);
            if (i==30){
                thread.start();

                try {
                    //用sleep方法使得主线程暂停，让thread线程立马执行
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThreadSleep extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"****"+i);
        }
    }
}
