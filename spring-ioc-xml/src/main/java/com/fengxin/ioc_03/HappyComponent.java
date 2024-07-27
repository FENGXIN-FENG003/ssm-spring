package com.fengxin.ioc_03;


/**
 * @author FENGXIN
 * 基于无参数构造函数
 */
public class HappyComponent implements A{

    //默认包含无参数构造函数

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}