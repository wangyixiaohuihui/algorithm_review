package com.wy.jvm.design.observer;

/**
 * @author by wangyi
 * @classname ConcreteObserver
 * @description TODO
 * @date 2020/9/30 19:08
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("update Observer 11111");
    }
}
