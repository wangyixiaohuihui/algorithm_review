package com.wy.algorithm.spi;

import org.apache.dubbo.common.URL;

/**
 * ClassName DubboAdaptiveExt2
 * Date 2019/11/1
 *
 * @author wangyi
 **/
public class DubboMyAdaptive implements MyAdaptive {
    @Override
    public void echo(String msg, URL url) {
        System.out.println("dubbo :"+ msg + "  current:"+ url.toFullString());
    }
}
