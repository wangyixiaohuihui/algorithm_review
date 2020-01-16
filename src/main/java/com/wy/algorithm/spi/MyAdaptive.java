package com.wy.algorithm.spi;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * SPI 接口
 * @author wangyi
 */
@SPI("dubbo")
public interface MyAdaptive {

    @Adaptive({"t"})
    public void echo(String msg, URL url);
}
