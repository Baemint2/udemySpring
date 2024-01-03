package com.moz1mozi.aopdemo.aspect;

import com.moz1mozi.aopdemo.Account;
import jdk.jshell.MethodSnippet;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Around("execution(* com.moz1mozi.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around (finally) on method: " + method);

        // print out method we are advising on
        long begin = System.currentTimeMillis();

        // get begin timestamp
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());

            // rethrow exception
            throw exc;
        }

        // now, let's execute the method

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n====> Duration: " + duration / 1000.0 + "seconds");

        return result;
    }

    @After("execution(* com.moz1mozi.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
// print out witch method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After (finally) on method: " + method);
        // log the exception

    }
    @AfterThrowing(
            pointcut = "execution(* com.moz1mozi.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        // print out witch method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method: " + method);
        // log the exception
        System.out.println("\n====> The exception os: " + theExc);
    }



    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.moz1mozi.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method: " + method);
        // print out the results of the method call
        System.out.println("\n====> result is: " + result);

        // let's post-process the data ... let's modify it :-_

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result){

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.moz1mozi.aopdemo.aspect.Moz1AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on method");


        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg : args) {
            System.out.println(tempArg);

            if(tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name : " + theAccount.getName());
                System.out.println("account name : " + theAccount.getLevel());
            }
        }
    }





}
