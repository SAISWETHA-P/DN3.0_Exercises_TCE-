package com.library2.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.library2.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void beforeMethod() {
        System.out.println("Before method execution");
    }

    @After("serviceMethods()")
    public void afterMethod() {
        System.out.println("After method execution");
    }
}