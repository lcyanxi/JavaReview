package com.javareview.common.String;

import java.util.Scanner;

/**
 * Created by lcyanxi on 2017/8/1.
 */
public class StringTest {
    public static void main(String args[]){
        System.out.println("请输入一个字符串：");
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        totalNum(string);
        resver(string);

    }

    public static void  totalNum(String str){
        int digitCount=0,englishCount=0,chineseCount=0;
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch>='0'&&ch<='9'){
              digitCount++;
            }else if ((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z')){
                englishCount++;
            }else {
                chineseCount++;
            }
        }
        System.out.println("数字个数为："+digitCount+"中文个数为："+chineseCount+"英文字母个数："+englishCount);
    }

    public static void resver(String string){
       int index= string.lastIndexOf(' ');
       System.out.println("--------"+index);
       while (index>=0){
           System.out.print(string.substring(index+1)+' ');
           string =string.substring(0,index);
           index=string.lastIndexOf(' ');
           System.out.println(index);
       }
       System.out.println("原始数据："+string);
    }
}
