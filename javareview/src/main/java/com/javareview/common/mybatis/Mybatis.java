package com.javareview.common.mybatis;

/**
 * Created by lcyanxi on 2017/7/23.
 */
public class Mybatis {
    /**
     * $和#的区别
     * # 是将传入的值当字符串的形式  被解析为一个参数占位符
     * eg:select id,name,age from student where id =#{id}
     *    select id,name,age from student where id ='1'.
     * $ 是将传入的值直接当sql显示    变量替换
     * eg:select id,name,age from student where id =${id}
     *    select id,name,age from student where id = 1.
     *
     *    #可以在很大程度上防止SQL注入（在SQL拼接的时候）
     *    在使用order by 的时候要使用$
     *
     *  大多数情况下使用#  一般特别的情况使用$
     */
}
