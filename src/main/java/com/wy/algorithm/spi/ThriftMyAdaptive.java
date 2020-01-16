package com.wy.algorithm.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * ClassName ThriftAdaptiveExt2
 * Date 2019/11/1
 *
 * @author wangyi
 **/
//@Adaptive
public class ThriftMyAdaptive implements MyAdaptive {
    @Override
    public void echo(String msg, URL url) {
        System.out.println("thrift :"+ msg + "  current:"+ url.toFullString());
    }
}
