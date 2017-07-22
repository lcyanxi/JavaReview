package com.javareview.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcyanxi on 2017/7/19.
 */
public class MapReview {

    public void hashMap(){
        Map<Integer,String> map=new HashMap<Integer, String>();
        map.put(1,"aaaa");
        map.put(6,"bbbb");
        map.put(3,"cccc");
        map.put(7,"dddd");
        //普通使用，二次取值
        for (Integer integer:map.keySet()){
            System.out.println("key"+integer+":value"+map.get(integer));
        }

    }


}
