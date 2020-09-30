package com.wy.algorithm.asm;

/**
 * ClassName MyClassLoader
 * Date 2019/10/23
 *
 * @author wangyi
 **/
public class MyClassLoader extends ClassLoader {

    public Class defineClass(String name, byte[] b) {
        return defineClass(name , b, 0, b.length);
    }
}
