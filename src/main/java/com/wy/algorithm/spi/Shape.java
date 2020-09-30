package com.wy.algorithm.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author wangyi
 */
@SPI("circle")
public interface Shape {
    /**
     * 接口画图方法
     */
    public void draw();
}
