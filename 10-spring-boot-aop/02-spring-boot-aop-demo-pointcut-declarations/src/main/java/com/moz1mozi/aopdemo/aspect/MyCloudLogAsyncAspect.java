package com.moz1mozi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {

    @Before("com.moz1mozi.aopdemo.aspect.Moz1AopExpressions.forDaoPackageNoGetterSetter()")
    public void logCloudAsync() {
        System.out.println("\n=====>>> Logging to Cloud in async fashion");


    }
}
