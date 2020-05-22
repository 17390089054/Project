/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MOAClient
 * Author:   knight
 * Date:     2019/11/1 0001 5:53
 * Description: MOA客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.wrtf.moa;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 〈一句话功能简述〉<br> 
 * 〈MOA客户端〉
 *
 * @author knight
 * @create 2019/11/1 0001
 * @since 1.0.0
 */
public class MOAClient {
    public static void main(String []args) throws  Exception{
        List<ParamObject>list2=new ArrayList<>();
        long start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
        //生产数据开始时间

            ParamObject po=new ParamObject();
            po.setUri("org.wrf.moa.MOAServer");
            //方法参数
            Object [] params=new Object[4];
            params[0]="string";
            params[1]=1;

            Map<String,Object> map=new HashMap<>();
            map.put("key",new String("key"));
            map.put("value",new String("value"));
            params[3]=map;

            List<String>list=new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            params[2]=list;

            po.setParams(params);
            //获取调用的远程方法
            String remoteMethod=MOAServer.class.getMethod("RPCMethod",String.class,Integer.class,List.class,Map.class).toString();

            po.setMethodName(remoteMethod);

            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(System.getProperty("user.dir")+"/data")));
            oos.writeObject(po);
            //System.out.println(po.toString().getBytes().length);
            oos.close();
            list2.add(new ParamObject());
        }



        long end=System.currentTimeMillis();
        System.out.println("produce comsumes:"+(end-start)+"ms");

//        String json= JSON.toJSONString(po);
//
//        StringBuilder sb=new StringBuilder();
//        sb.append("$").append(json.length()).append("\r\n").append(json).append("\r\n");
//        System.out.println(sb.toString());


        long s=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            HandlerMapping mapping=new HandlerMapping();
            String md5=mapping.handler();
            System.out.println(md5);
        }
        long e=System.currentTimeMillis();

        System.out.println("comsumer consumes "+(e-s)+"ms");
    }


}