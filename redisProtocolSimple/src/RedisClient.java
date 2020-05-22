/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisClient
 * Author:   knight
 * Date:     2019/10/31 0031 0:03
 * Description: Redis客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Redis客户端〉
 *
 * @author knight
 * @create 2019/10/31 0031
 * @since 1.0.0
 */
public class RedisClient {
    public static void main(String []args){

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            String str=new String("hello");
            sb.append("$"+str.length()+"\r\n"+str+"\r\n");
        }
        System.out.println(sb.toString());

        Transfer trans=new Transfer();


    }

    @Test
    public void  SerializeAndDeSerilize(){
        try{
            Transfer t=new Transfer();
            t.setClassName("org.wrf.TestClass");
            t.setMethodName("getMethod");
            HashMap<Object,Object>map=new HashMap<>();
            map.put("str",1);
            map.put("num",2);
            map.put("test",3);
            List<String>lists=new ArrayList<>();
            lists.add("i");
            lists.add("am");
            lists.add("a");
            lists.add("student");

            t.setParams(new Object[]{map,lists});

            //System.out.println(t);
            //序列化
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("serialize"));
            oos.writeObject(t);
            oos.close();
            //反序列化
            File file=new File(System.getProperty("user.dir")+"/serialize");
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
            Transfer transfer=(Transfer) ois.readObject();
            System.out.println(transfer);
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}