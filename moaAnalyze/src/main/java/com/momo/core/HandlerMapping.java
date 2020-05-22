package com.momo.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.momo.pojo.ParamObject;
import com.momo.server.ServerClass;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/28
 * Description:
 */
public class HandlerMapping {

    private Map<String, ServerProsser> map = new HashMap<>();

    public HandlerMapping() {
        init();
    }

    public void init(){
        //初始化
        ServerProsser serverProsser=new ServerProsser();
        serverProsser.setInstance(new ServerClass());
        Map<String,Method> methodMap=new HashMap<>();
        for (Method method : ServerClass.class.getMethods()) {
            methodMap.put(method.toString(),method);
        }
        serverProsser.setMap(methodMap);
        map.put("/com/momo/server/serverclass",serverProsser);
    }

    public String methodForward(String key) {
        try {
            ParamObject paramObject = get(key);
            ServerProsser serverProsser = map.get(paramObject.getAction());
            if(serverProsser==null) throw new ClassNotFoundException(key);
            Object[] prarms = paramObject.getPrarms();
            //获取参数
            Method method = serverProsser.getMap().get(paramObject.getMethodName());
            //参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] prarmsObjects = paramObject.getPrarms();
            for (int i = 0; i <prarmsObjects.length; i++) {
                Object o = JSONObject.parseObject(prarmsObjects[i].toString(), parameterTypes[i]);
                prarmsObjects[i]=o;
            }
            Object invoke = method.invoke(serverProsser.getInstance(), prarmsObjects);
            return invoke.toString();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "error";
    }


    private ParamObject get(String key) {
        // return "解析key的数据";
        if (key == null) return null;
        String trim = key.trim();
        String[] res = trim.split("/r/n");
        if (res.length < 2 || !res[0].startsWith("$")) {
            return null;
        }
        JSONObject jsonObject = JSONObject.parseObject(res[1]);
        String serveId = (String) jsonObject.get("action");
        String methodName = (String) jsonObject.get("methodName");
        JSONArray array = (JSONArray) jsonObject.get("prarms");

        ParamObject paramObject=new ParamObject();
        Object[] objects = array.toArray();
        paramObject.setAction(serveId);
        paramObject.setPrarms(objects);
        paramObject.setMethodName(methodName);
        return paramObject;
    }

}
