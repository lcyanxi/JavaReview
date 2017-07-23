package com.javareview.common.Thread;


/**
 * Created by lcyanxi on 2017/7/22.
 */
public class AccountTreadTest {
    /**
     * wait()方法执行后，当前线程立即进入到等待阻塞状态，其后面的代码不会执行
     * notify()/notifyAll()方法执行后，将唤醒此同步锁对象上的线程对象
     * 当wait线程唤醒后并执行时，是接着上次执行到的wait()方法代码后面继续往下执行的
     *
     * 避免多线程环境下对此共享资源的并发访问:
     * Lock对象同步锁
     * 同步代码块
     * 同步方法  方法定义中加上synchronized关键字修饰
     */
    public  static void main(String args[]){
        Account account=new Account("111111",0);

        Thread thread=new SaveMoneyThread("存钱进程：",account,500);
        Thread thread1=new TakeMoneyThread("取钱线程：",account,300);

        thread.start();
        thread1.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("主线程执行完-------------------");
    }



}
class TakeMoneyThread extends Thread{
    private  Account account;
    private double amount;

    public TakeMoneyThread(String name, Account account, double amount) {
        super(name);
        System.out.println("取钱线程初始化");
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i=0;i<50;i++){
           account.TakeMoney(amount,i);
        }
    }
}
class SaveMoneyThread extends Thread{

    private Account account;
    private double amount;

    public SaveMoneyThread(String name, Account account, double amount) {
        super(name);
        System.out.println("存钱线程初始化");
        this.account = account;
        this.amount = amount;
    }


    @Override
    public void run() {
        for (int i=0;i<50;i++){
            account.saveMoney(amount,i);
        }
    }
}
class Account{
    private String accountNo;
    private double blance;
    //标记账户中是否有存款
    private boolean flage=false;

    public Account() {
    }

    public Account(String accountNo, double blance) {
        System.out.println("初始化账户");
        this.accountNo = accountNo;
        this.blance = blance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBlance() {
        return blance;
    }

    public void setBlance(double blance) {
        this.blance = blance;
    }

    /**
     * 存钱
     * @param saveMoney
     * @param i
     */
    public synchronized void saveMoney(double saveMoney,int i){
        if (flage){
            //当账户中有人存钱，线程需要等待
            System.out.println(Thread.currentThread().getName()+"save Money方法的wait方法执行"+i);
            try {
                wait();
             System.out.println(Thread.currentThread().getName()+"wait方法已经执行了"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            //开始存钱
            System.out.println(Thread.currentThread().getName()+"存款："+saveMoney+"---i="+i);
            setBlance(blance+saveMoney);
            flage=true;
            //唤醒其他线程
            notifyAll();

            try {
               long start=  System.currentTimeMillis();
                Thread.sleep(30);
                System.out.println(Thread.currentThread().getName()+"存钱sleep执行"+i);
                System.out.println(System.currentTimeMillis()-start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱完毕"+i);
        }
    }

    public synchronized void TakeMoney(Double takeMoney,int i){
        if (!flage){
            //当前还没有人存钱  ，线程等待
            System.out.println(Thread.currentThread().getName()+"TakeMoney开始执行wait方法"+i);
            try {
                wait();
             System.out.println(Thread.currentThread().getName()+"wait方法执行完"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"取钱："+takeMoney+"----i="+i);
            setBlance(blance-takeMoney);
            flage=false;
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName()+"取钱完毕"+i);

    }
}
