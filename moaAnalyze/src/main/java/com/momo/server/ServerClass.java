package com.momo.server;

import java.util.List;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/28
 * Description:
 */
public class ServerClass {

    public String remoteMethod(String s, List<Integer> list, Map<String, Student> map) {
        System.out.println(s);
        System.out.println(list);
        System.out.println(map);
        return "md5";
    }

}
