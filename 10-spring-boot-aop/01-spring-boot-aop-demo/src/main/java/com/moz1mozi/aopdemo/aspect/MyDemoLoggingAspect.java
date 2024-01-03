package com.moz1mozi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


//    @Before("execution(public void addAccount())")

//    @Before("execution(public void add*())")

    @Before("execution(* com.moz1mozi.aopdemo.dao.*.*(..))")

    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");
    }
}
