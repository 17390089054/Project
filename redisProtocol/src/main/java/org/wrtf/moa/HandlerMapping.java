/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HandlerMapping
 * Author:   knight
 * Date:     2019/11/1 0001 6:16
 * Description: 处理映射请求
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.wrtf.moa;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.tools.packager.Param;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈处理映射请求〉
 *
 * @author knight
 * @create 2019/11/1 0001
 * @since 1.0.0
 */
public class HandlerMapping {
    private Map<String,ServerInstance> map=new HashMap<>();

    {
        ServerInstance instance=new ServerInstance();
        instance.setInstance(new MOAServer());
        Map<String, Method> methodMap=new HashMap<>();
        for(Method method:MOAServer.class.getMethods()){
            methodMap.put(method.toString(),method);
        }
        instance.setMap(methodMap);
        map.put("org.wrf.moa.MOAServer",instance);
    }

    public String handler(){
        try {
            ParamObject paramObject=parserParam();
            ServerInstance si=map.get(paramObject.getUri());
            if(si==null)
                throw new ClassNotFoundException();
            //参数列表
            Object[] params=paramObject.getParams();
            //获取方法对象
            Method method=si.getMap().get(paramObject.getMethodName());
            //参数类型
            Class<?>[] parameterTypes=method.getParameterTypes();
            //解析参数
            Object[] parameterObjects=paramObject.getParams();
//            for(int i=0;i<parameterObjects.length;i++){
//                Object o=JSONObject.parseObject(parameterObjects[i].toString(),parameterTypes[i]);
//                parameterObjects[i]=o;
//            }
            Object invoke=method.invoke(si.getInstance(),parameterObjects);
            return invoke.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

        return "handler exception";
    }

    public ParamObject parserParam() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir")+"/data")));
        ParamObject po=(ParamObject) ois.readObject();
        return po;
    }



}