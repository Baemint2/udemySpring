package com.moz1mozi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Moz1AopExpressions {
    @Pointcut("execution(* com.moz1mozi.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.moz1mozi.aopdemo.dao.*.get*(..)))")
    public void getter() {}

    @Pointcut("execution(* com.moz1mozi.aopdemo.dao.*.set*(..)))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}


}
