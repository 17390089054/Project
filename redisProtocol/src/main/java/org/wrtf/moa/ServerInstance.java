/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ServerInstance
 * Author:   knight
 * Date:     2019/11/1 0001 6:17
 * Description: 服务对象实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.wrtf.moa;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务对象实例〉
 *
 * @author knight
 * @create 2019/11/1 0001
 * @since 1.0.0
 */
public class ServerInstance {
    private Map<String, Method> map=new HashMap<>();
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