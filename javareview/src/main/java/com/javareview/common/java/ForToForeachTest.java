package com.javareview.common.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcyanxi on 2017/7/28.
 */
public class ForToForeachTest {
    /**
     *  foreach语句的局限性
     如果要引用数组或者集合的索引，则foreach语句无法做到，foreach仅仅老老实实地遍历数组或者集合一遍。
     * 1.如果只是遍历集合或者数组，用foreach好些，快些
     * 2.如果对集合中的值进行修改，就要用for循环了。其实foreach的内部原理其实也是Iterator,但它不能像Iterator一样可以人为的控制，
     * 而且也不能调用iterator.remove()；更不能使用下标来访问每个元素，所以不能用于增加，删除等复杂的操作。
     *
     * @param args
     */
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        for (int i=0;i<list.size();i++){
            list.add("fff");
            System.out.println("----------");
            System.out.println(list.get(i));
            list.add("ddd");
            list.add("eee");
        }
        for (String s : list) {
            System.out.println(s);
            list.add("ccc");
        }
    }
}
