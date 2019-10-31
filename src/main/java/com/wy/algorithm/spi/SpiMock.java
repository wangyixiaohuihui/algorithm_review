package com.wy.algorithm.spi;

import java.util.ServiceLoader;

/**
 * ClassName SpiMock
 * Date 2019/10/31
 *
 * @author wangyi
 **/
public class SpiMock {

    public static void main(String[] args) {
        ServiceLoader<Shape> serviceLoader = ServiceLoader.load(Shape.class);
        for(Shape shape : serviceLoader) {
            shape.drea();
        }
    }
}
