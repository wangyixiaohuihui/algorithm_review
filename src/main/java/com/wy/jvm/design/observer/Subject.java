package com.wy.jvm.design.observer;


import java.util.ArrayList;

/**
 * @author by wangyi
 * @classname Subject
 * @description TODO
 * @date 2020/9/30 18:53
 */
abstract class Subject {

    /**
     * 观察者集合 用于存储所有的观察者对象
      */
    protected  ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyList();

}
