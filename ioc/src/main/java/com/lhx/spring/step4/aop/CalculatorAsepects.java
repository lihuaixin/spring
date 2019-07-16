package com.lhx.spring.step4.aop;

import org.aspectj.lang.JoinPoint;
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
    public void logAfter(JoinPoint joinpoint) {
        System.out.println("logAfter.... " + joinpoint.getSignature().getName() + " 参数" + joinpoint.getArgs());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("logAfterReturning.... " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinpoint, Exception exception) {
        System.out.println("logAfterThrowing.... " + exception.getMessage());
    }

    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("logAround start .... ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("logAround end .... ");
        return proceed;
    }


}
