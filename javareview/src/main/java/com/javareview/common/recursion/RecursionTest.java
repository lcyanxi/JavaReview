package com.javareview.common.recursion;

import java.util.Scanner;

/**
 * 递归调用用栈溢出性能问题
 * Created by lcyanxi on 2017/7/31.
 */
public class RecursionTest {
    public static void main(String args[]){
      Scanner scanner=new Scanner(System.in);
      /*   int n=scanner.nextInt();*/
       /* recursion(9);*/
      /*  System.out.println(n+"!=:"+recursion2(n));*/
     /* System.out.println("--------------------------");
        doubleFor(9);*/

     int array[]={5,4,9,7,3,6,0,7,2};
     bubble(array);
    }

    /**
     * 九九乘法表  递归调用
     * @param i
     */
    public  static void  recursion(int i){
        if (i==1){
            System.out.println("1*1=1");
        }else {
            recursion(i-1);
            for (int j=1;j<=i;j++){
                System.out.println(j+"*"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }

    public  static void doubleFor(int i){
        for (int m=1;m<=i;m++){
            for (int n=1;n<i;n++){
                System.out.println(m+"*"+n+"="+m*n+"");
            }
            System.out.println();
        }
    }

    /**
     * N!阶乘
     * @param n
     * @return
     */
    public static double  recursion2(int n){
        if (n==1||n==0){
           return  1;
        }else {
            return  n*recursion2(n-1);
        }
    }
    /**
     * 冒泡算法
     */

    public static void  bubble(int [] index){
        for (int i=0;i<index.length-1;i++){
            for (int j=0;j<index.length-i-1;j++){
                if (index[j]>index[j+1]){
                    int current=index[j];
                    index[j]=index[j+1];
                    index[j+1]=current;
                }
            }
        }
        for (Integer integer:index){
            System.out.print(integer+" ");
        }
    }

}
