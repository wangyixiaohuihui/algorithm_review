package com.wy.algorithm.spi;

import org.apache.dubbo.common.extension.Adaptive;

/**
 * ClassName Circle
 * Date 2019/10/31
 *
 * @author wangyi
 **/
@Adaptive
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a Circle");
    }
}
