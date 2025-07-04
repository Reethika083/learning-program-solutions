package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeAdvice() {
        System.out.println("[AOP] 🔍 Before method execution");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice() {
        System.out.println("[AOP] ✅ After method execution");
    }
}
