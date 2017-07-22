package com.javareview.common;

/**
 * Created by lcyanxi on 2017/7/22.
 */
public class GcReview {
    /**
     * GC java的垃圾回收机制
     * 时间：这是由系统不可预测时间调用System.gc()方法，当然我们也可以通过自己手动调用这个方法，
     * 事物：对超出了作用域或者引用计数为空的对象进行回收，方式是从gc root开始搜索不到的对象经过一次
     * 标记、清理仍然没有复活的对象进行回收。
     * 操作：删除不使用的对象，回收内存空间。
     */
}
