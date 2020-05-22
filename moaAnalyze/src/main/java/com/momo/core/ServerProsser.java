package com.momo.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/29
 * Description:
 */
public class ServerProsser {
    //方法表
    private Map<String, Method> map = new HashMap<>();
    private Object instance;

    public Map<String, Method> getMap() {
        return map;
    }

    public void setMap(Map<String, Method> map) {
        this.map = map;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }


}
