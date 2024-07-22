package com.fengxin.ioc_01;

/**
 * @author FENGXIN
 * @date 2024/7/22
 **/
public class DefaultService {
    private static Service service = new Service ();
    public Service createInstance(){
        return service;
    }
    
}
