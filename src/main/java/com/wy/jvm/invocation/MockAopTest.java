package com.wy.jvm.invocation;

import java.lang.reflect.Proxy;

/**
 * ClassName MockAopTest
 * Date 2019/2/15
 *
 * @author wangyi
 **/
public class MockAopTest {

    public static void main(String[] args) {

        MockJdkAop mockJdkAop = new MockJdkImplA();

        ClassLoader classLoader = MockAopTest.class.getClassLoader();

        Class[] interfaces = mockJdkAop.getClass().getInterfaces();

        MockInvocation mockInvocation = new MockInvocation(mockJdkAop);

        MockJdkAop mockJdkAopProxy = (MockJdkAop)Proxy.newProxyInstance(classLoader, interfaces, mockInvocation);

        String r= mockJdkAopProxy.getName("heiheihei");

        System.out.println(r);
    }
}
