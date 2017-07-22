package com.javareview.common;

/**
 * Created by lcyanxi on 2017/7/20.
 */
public class VariantTest {
    public static int staticVar = 0;
    public int instanceVar = 0;
    public VariantTest(){
        staticVar++;
        instanceVar++;
        System.out.println("staticVar= "+ staticVar + ",instanceVar=" + instanceVar);
    }


    public  static  void main(String args []) {
            VariantTest variantTest=new VariantTest();
            System.out.println(variantTest.get());

    }
    public int  get()
    {
        try
        {
            return 1 ;
        }
        finally
        {
            return 2 ;
        }
    }

}
