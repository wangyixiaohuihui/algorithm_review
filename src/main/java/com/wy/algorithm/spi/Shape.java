package com.wy.algorithm.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author wangyi
 */
@SPI("circle")
public interface Shape {
    public void draw();
}
