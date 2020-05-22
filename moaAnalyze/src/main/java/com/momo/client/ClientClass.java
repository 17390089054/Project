package com.momo.client;

import com.alibaba.fastjson.JSON;
import com.momo.core.HandlerMapping;
import com.momo.pojo.ParamObject;
import com.momo.server.ServerClass;
import com.momo.server.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/28
 * Description:
 */
public class ClientClass {
    private List<String> list = new ArrayList<>();

    public void clientMethod() throws NoSuchMethodException {

        ParamObject p=new ParamObject();
        p.setAction("/com/momo/server/serverclass");
        Object[] objects=new Object[3];
        objects[0]="1";
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        objects[1]=list;
        Map<String,Student> map=new HashMap<>();
        Student student=new Student();
        student.setId(1);
        student.setName("1111");
        map.put("1",student);
        map.put("2",student);
        objects[2]=map;
        p.setPrarms(objects);
        String remoteMethod = ServerClass.class.getMethod("remoteMethod", String.class, List.class, Map.class).toString();
        p.setMethodName(remoteMethod);
        String json = JSON.toJSON(p).toString();
        //System.out.println(key);
        StringBuilder s=new StringBuilder();
        s.append("$").append(json.length()).append("/r/n").append(json).append("/r/n");
        System.out.println(s.toString());
        HandlerMapping mapping = new HandlerMapping();
        String md5 = mapping.methodForward(s.toString());
        System.out.println();
        //List<String> res = list.stream().map(key -> mapping.methodForward(s)).collect(Collectors.toList());
    }

    public static void main(String[] args) throws NoSuchMethodException {
        new ClientClass().clientMethod();
    }

}
