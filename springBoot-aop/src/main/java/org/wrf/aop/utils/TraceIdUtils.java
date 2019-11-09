package org.wrf.aop.utils;

import java.util.UUID;

/**
 * @program: springBoot-aop
 * @description: 生成traceId
 * @author: Wang.Rongfu
 * @create: 2019-11-09 18:00
 **/
public class TraceIdUtils {
    public static String generateTraceId(){
        return UUID.randomUUID().toString().toString().replaceAll(" ","-");
    }
}
