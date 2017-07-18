package com.common.test;

import com.javareview.common.ListReview;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lcyanxi on 2017/7/18.
 */
public class ListReviewTest {
    /**
     * 同步性
     Vector是同步的。对象是线程安全的。而ArrayList则是异步的，对象并不是线程安全的。因为同步的要求会影响执行的效率，
     数据增长
     从内部实现机制来讲ArrayList和Vector都是使用数组(Array)来控制集合中的对象。
     当你向这两种类型中增加元素的时候，如果元素的数目超出了内部数组目前的长度它们都需要扩展内部数组
     的长度，Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%,所以最后你获得的这个
     集合所占的空间总是比你实际需要的要大。所以如果你要在集合中保存大量的数据那么使用Vector有一些
     优势，因为你可以通过设置集合的初始化大小来避免不必要的资源开销。
     */

    @Test
    public void testListReview(){
        System.out.println("添加10000000条数据ArrayList所用时间："+ListReview.timeList(new ArrayList()));
        System.out.println("添加10000000条数据LinkedList所用时间："+ListReview.timeList(new LinkedList()));

     List list=ListReview.addList(new ArrayList());
     List list1=ListReview.addList(new LinkedList());
     System.out.println("ArrayList查找10000000条数据所需时间："+ListReview.readList(list));
     System.out.println("LinkedList查找10000000条数据所需时间："+ListReview.readList(list1));
    }
}
