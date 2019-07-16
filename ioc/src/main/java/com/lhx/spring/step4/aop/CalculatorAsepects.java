package com.lhx.spring.step4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * Created by lihuaixin on 2019/7/16 15:34
 */
@Component
@Aspect
public class CalculatorAsepects {
    @Pointcut("execution(public int com.lhx.spring.step4.aop.Calculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart() {
        System.out.println("logBefore.... ");
    }

    @After("pointCut()")
    public void logAfter() {
        System.out.println("logAfter.... ");
    }

    @AfterReturning("pointCut()")
    public void logAfterReturning() {
        System.out.println("logAfterReturning.... ");
    }

    @AfterThrowing("pointCut()")
    public void logAfterThrowing() {
        System.out.println("logAfterThrowing.... ");
    }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("logAround start .... ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("logAround end .... ");
        return proceed;
    }


}
