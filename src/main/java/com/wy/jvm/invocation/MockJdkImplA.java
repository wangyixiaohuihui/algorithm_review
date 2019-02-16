package com.wy.jvm.invocation;

/**
 * ClassName MockJdkImplA
 * Date 2019/2/15
 *
 * @author wangyi
 **/
public class MockJdkImplA implements MockJdkAop {
    @Override
    public String getName(String name) {

        System.out.println("getName======:"+ name);

        return name;
    }
}
