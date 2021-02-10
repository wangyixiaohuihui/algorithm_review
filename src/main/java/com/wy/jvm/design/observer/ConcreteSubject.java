package com.wy.jvm.design.observer;

/**
 * @author by wangyi
 * @classname ConCreateSubject
 * @description TODO
 * @date 2020/9/30 19:03
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyList() {
        for (Observer obs: observers) {
            obs.update();
        }
    }
}
