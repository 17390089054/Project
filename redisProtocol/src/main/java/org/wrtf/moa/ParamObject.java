/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ParamObject
 * Author:   knight
 * Date:     2019/11/1 0001 5:57
 * Description: 参数对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.wrtf.moa;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈参数对象〉
 *
 * @author knight
 * @create 2019/11/1 0001
 * @since 1.0.0
 */
public class ParamObject implements Serializable {
    private String uri;
    private String methodName;
    private Object []params;

    public String getUri() {
        return uri;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}