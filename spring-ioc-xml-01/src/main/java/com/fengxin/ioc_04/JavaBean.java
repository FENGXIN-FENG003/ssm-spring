package com.fengxin.ioc_04;

/**
 * @author FENGXIN
 * @date 2024/7/23
 **/
public class JavaBean {
    /*
    初始化方法
    public void 无参数
     */
    public void init(){
        System.out.println ("init...");
    }
    /*
    销毁方法
     */
    public void clear(){
        System.out.println ("destroy...");
    }
}
