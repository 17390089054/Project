/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Transfer
 * Author:   knight
 * Date:     2019/10/31 0031 0:06
 * Description: 传输对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.io.Serializable;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈传输对象〉
 *
 * @author knight
 * @create 2019/10/31 0031
 * @since 1.0.0
 */
public class Transfer implements Serializable {
    private String className;
    private String methodName;
    private Object []params;

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}