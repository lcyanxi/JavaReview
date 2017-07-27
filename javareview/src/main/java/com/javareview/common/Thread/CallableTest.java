package com.javareview.common.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class CallableTest {
    public static void main(String args[]){
        Callable<Integer> callable=new MyCallable();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(callable);

        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+""+i);

            if (i==30){
                System.out.println("创建Callable线程");

                Thread thread=new Thread(futureTask);
                thread.start();
            }
        }
        System.out.println("主线程执行完毕");

        try {
            int sum=futureTask.get();//获取新建线程call（）的返回值

            //为什么它会一直最后输出
            //子线程方法还未执行完毕，ft.get()方法会一直阻塞，直到call()方法执行完毕才能取到返回值。
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class MyCallable implements Callable<Integer> {
    List list=new ArrayList();
    int sum = 0;

    public Integer call() throws Exception {
        list.add("aaaa");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "" + i);


            sum += i;
        }
        return sum;
    }
}