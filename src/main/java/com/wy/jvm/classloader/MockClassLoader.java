package com.wy.jvm.classloader;

/**
 * ClassName MockClassLoader
 * Date 2019/3/14
 *
 * @author wangyi
 **/
public class MockClassLoader {



    int a =10;

    static {
        System.out.println("load 111");
    }

    public static MockClassLoader st = new MockClassLoader();

    static {
        System.out.println("load static  111");
    }

    {
        System.out.println("load 2222");
    }
    static int b =110;



    public MockClassLoader(){
        System.out.println("33");
        System.out.println("a="+a +"  b="+b);
    }

    public  static void staticFunction(){
        System.out.println("44");
    }




    public static void main(String[] args) {
        staticFunction();
    }


}
