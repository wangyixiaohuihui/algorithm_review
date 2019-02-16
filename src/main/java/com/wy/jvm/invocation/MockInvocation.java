package com.wy.jvm.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName MockInvocation
 * Date 2019/2/15
 *
 * @author wangyi
 **/
public class MockInvocation implements InvocationHandler {


    private MockJdkAop  mockJdkAop;


    public MockInvocation(MockJdkAop mockJdkAop){

        this.mockJdkAop = mockJdkAop;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy before =======");

        Object invoke = method.invoke(mockJdkAop, args);

        System.out.println("proxy end ========");

        return invoke;
    }

}
