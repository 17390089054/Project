/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MOAServer
 * Author:   knight
 * Date:     2019/11/1 0001 5:59
 * Description: MOA服务端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.wrtf.moa;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈MOA服务端〉
 *
 * @author knight
 * @create 2019/11/1 0001
 * @since 1.0.0
 */
public class MOAServer{
    public String RPCMethod(String s,Integer i,List<Integer>list, Map<String,Object> map){
//        System.out.println(s);
//        System.out.println(i);
//        System.out.println(list);
//        System.out.println(map);
        Object []objects=new Object[4];
        objects[0]=s;
        objects[1]=i;
        objects[2]=list;
        objects[3]=map;
        return MD5Utils.generateMD5(objects.toString());
    }

}