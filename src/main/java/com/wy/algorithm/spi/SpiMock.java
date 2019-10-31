package com.wy.algorithm.spi;

import java.util.ServiceLoader;

/**
 * ClassName SpiMock
 * Date 2019/10/31
 *
 * @author wangyi
 * 1. META-INF/services 创建一个以接口名称命名的文件
 * 2. 文件中写顶类的全路径
 *
 *
 **/
public class SpiMock {

    public static void main(String[] args) {
        // class.newInstance()
        ServiceLoader<Shape> serviceLoader = ServiceLoader.load(Shape.class);
        for(Shape shape : serviceLoader) {
            shape.draw();
        }
    }
}
