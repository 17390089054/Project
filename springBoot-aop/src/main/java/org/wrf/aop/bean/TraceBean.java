package org.wrf.aop.bean;

/**
 * @program: springBoot-aop
 * @description:
 * @author: Wang.Rongfu
 * @create: 2019-11-09 13:34
 **/
public  class TraceBean{
    private String traceId;
    private String url;
    private String httpMethod;
    private String methodName;
    private String spendTime;

    public String getTraceId() {
        return traceId;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public String getHttpMethod() {
        return httpMethod;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public String toString() {
        return "TraceBean{" +
                "traceId='" + traceId + '\'' +
                ", url='" + url + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", methodName='" + methodName + '\'' +
                ", spendTime='" + spendTime + '\'' +
                '}';
    }
}
