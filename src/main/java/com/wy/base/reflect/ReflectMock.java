package com.wy.base.reflect;

import java.lang.reflect.Method;

/**
 * ClassName ReflectMock
 * Date 2019/1/28
 * 反射相关代码测试
 * @author wangyi
 **/
public class ReflectMock {

    public static void main(String[] args) {
        try {

            Proxy target = new Proxy();
            // 每次调用这个方法， 都是一个新的对象
            Method method = Proxy.class.getDeclaredMethod("run");
            method.invoke(target);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }

}
