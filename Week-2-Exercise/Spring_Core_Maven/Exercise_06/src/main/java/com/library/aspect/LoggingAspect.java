package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.library.service.BookService.performService(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method {} is about to execute", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.library.service.BookService.performService(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method {} has finished executing", joinPoint.getSignature().getName());
    }
}
