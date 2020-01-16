package com.wy.algorithm.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author wangyi
 * date: {DATE}
 *
 *
 **/
public class DubboSPI {

    public static void main(String[] args) {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(Shape.class);

//        Shape shape = (Shape) extensionLoader.getDefaultExtension();
//        shape.draw();

//        Shape shape2 = (Shape) extensionLoader.getExtension("rect");
//        shape2.draw();

        //Adaptive
        Shape shape2 = (Shape) extensionLoader.getAdaptiveExtension();
        shape2.draw();


    }


}
