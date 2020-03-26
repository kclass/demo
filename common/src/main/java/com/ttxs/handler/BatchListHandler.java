package com.ttxs.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kai.hu
 * @date 2020/3/26 16:02
 */
@Component
@Aspect
public class BatchListHandler {

    @Pointcut("@annotation(com.ttxs.annotation.BatchList)")
    public void breakBatch() {}

    @Around(value = "breakBatch()")
    public Object doBefore(ProceedingJoinPoint  point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof List) {
                ((List) arg).add("2343214");
                break;
            }
        }
        return point.proceed(args);
    }
}
