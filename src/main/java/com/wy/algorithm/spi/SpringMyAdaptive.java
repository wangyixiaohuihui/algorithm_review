package com.wy.algorithm.spi;

import org.apache.dubbo.common.URL;

/**
 * ClassName SpringAdaptiveExt2
 * Date 2019/11/1
 *
 * @author wangyi
 **/
public class SpringMyAdaptive implements MyAdaptive {
    @Override
    public void echo(String msg, URL url) {
        System.out.println("Spring :"+ msg + "  current:"+ url.toFullString());
    }
}
