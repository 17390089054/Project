package com.momo.pojo;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/28
 * Description:
 */
public class ParamObject {
    private String action;
    private String methodName;
    private Object[] prarms;

    public String getAction() {
        return action;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object[] getPrarms() {
        return prarms;
    }

    public void setPrarms(Object[] prarms) {
        this.prarms = prarms;
    }
}
