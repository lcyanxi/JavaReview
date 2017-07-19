package com.javareview.common.singleton;

/**
 * Created by lcyanxi on 2017/7/18.
 */
public class SingletonReview {
    /**
     *  饿汉式
     * 类加载的时候就对实例进行创建，实例在整个程序周期都存在，避免多线程同步
     * 缺点，单例没有用到也会被创建，在类加载之后就被创建，内存浪费。
     */

    private static SingletonReview singletonReview=new SingletonReview();
    private  SingletonReview(){}
    public static SingletonReview getSingletonReview(){
        return  singletonReview;
    }


    /**
     * 懒汉式
     *延迟加载--需要的时候才去创建
     *缺点： 多个线程可能会并发调用它的getInstance()方法
     */

    private static SingletonReview singletonReview1=null;
    //private SingletonReview(){}
    public static SingletonReview newSingletonReview(){
        if (singletonReview1==null){
            singletonReview1=new SingletonReview();
        }
        return  singletonReview1;
    }

    /**
     *  加锁的懒汉式--线程安全
     *  synchronized修饰的同步方法比一般方法要慢很多
     */

    private static SingletonReview singletonReview2=null;
    //private  SingletonReview(){}
    public  static synchronized  SingletonReview getSingletonReview2(){
        if (singletonReview2==null){
            singletonReview2=new SingletonReview();
        }
        return  singletonReview2;
    }

    /**
     * 双重校验锁（推荐）
     * 双重校验锁会失效,由于指令重排优化的存在,解决方案JDK1.5及之后版本增加了
     * volatile（类型修饰符）关键字，volatile的变量是会被意想不到地改变，编译器就不会去假设这个变量的值
     */

    private  static volatile SingletonReview singletonReview3=null;
    //private SingletonReview(){}
    public static SingletonReview getSingletonReview3(){
        if (singletonReview3==null){
            synchronized (SingletonReview.class){
                if (singletonReview3==null){
                    singletonReview3=new SingletonReview();
                }
            }
        }
        return singletonReview3;
    }

    /**
     * 静态内部类（推荐）
     * 延迟加载和线程安全
     * 只要应用中不使用内部类，JVM就不会去加载这个单例类，也就不会创建单例对象
     */
    public static class SingletonHandler{
        private  static SingletonReview singletonReview4 =new SingletonReview();
    }
    //private SingletonReview(){}
    public static SingletonReview getSingletonReview4(){
        return  SingletonHandler.singletonReview4;
    }


    //枚举   用得比较少
    public enum Singleton{
        instance;
        public void whateverMethod(){}
    }

}

