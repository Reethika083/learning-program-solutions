package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object returnValue = joinPoint.proceed(); // proceed with actual method

        long end = System.currentTimeMillis();
        System.out.println("⏱ Method [" + joinPoint.getSignature() + "] executed in " + (end - start) + " ms");

        return returnValue;
    }
}
