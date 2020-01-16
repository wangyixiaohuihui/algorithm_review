package com.wy.algorithm.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

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
//        // class.newInstance()
//        ServiceLoader<Shape> serviceLoader = ServiceLoader.load(Shape.class);
//        for(Shape shape : serviceLoader) {
//            shape.draw();
//        }

        /**
         * 1、 接口SPI 注解value值
         * 结果： dubbo :d  current:test://localhost/test
         */
        ExtensionLoader<MyAdaptive> extensionLoader = ExtensionLoader.getExtensionLoader(MyAdaptive.class);
        MyAdaptive adaptiveExt2 = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        adaptiveExt2.echo("d", url);


        /**
         * 2、SPI注解中有value值，URL中也有具体值
         * 结果： Spring :d  current:test://localhost/test?my.adaptive=cloud
         */
        MyAdaptive adaptiveExt3 = extensionLoader.getAdaptiveExtension();
        URL url3 = URL.valueOf("test://localhost/test?my.adaptive=cloud");
        adaptiveExt3.echo("d", url3);


        /**
         * 3、SPI注解中有值，URL中也有具体值， 实现类上也有@Adaptive 注解
         *
         * 结果：thrift :d  current:test://localhost/test?my.adaptive=cloud
         */
        MyAdaptive adaptiveExt4 = extensionLoader.getAdaptiveExtension();
        URL url4 = URL.valueOf("test://localhost/test?my.adaptive=cloud");
        adaptiveExt4.echo("d", url4);


        /**
         * SPI 注解中有value值， 实现类上没有@Adaptive 注解， 方法上有@Adaptive注解，注解中的value
         * 与 连接中的参数key 一致，连接中的key 对应的value 就是SPI中的name，获取相应的实现类
         */

        MyAdaptive adaptiveExt5 = extensionLoader.getAdaptiveExtension();
        URL url5 = URL.valueOf("test://localhost/test?t=cloud");
        adaptiveExt5.echo("5", url5);




    }


}
