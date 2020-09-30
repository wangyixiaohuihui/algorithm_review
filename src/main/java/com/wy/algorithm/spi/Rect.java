package com.wy.algorithm.spi;

import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author wangyi
 * date: {DATE}
 **/

@Adaptive
public class Rect implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a Rect");
    }
}
