package com.fengxin.ioc_01;

/**
 * @author FENGXIN
 * @date 2024/7/22
 **/
public class ClientService {
    private static ClientService clientService = new ClientService ();
    private ClientService(){}
    // 通过静态方法返回创建的实例对象
    public static ClientService createInstance(){
        return clientService;
    }

}
