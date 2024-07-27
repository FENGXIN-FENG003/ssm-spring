package com.fengxin.ioc_05;

/**
 * @author FENGXIN
 * @date 2024/7/24
 **/
public class JavaBean {
    private String name;
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public String toString () {
        return "JavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
