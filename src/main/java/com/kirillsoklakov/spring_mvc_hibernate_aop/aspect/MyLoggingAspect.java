package com.kirillsoklakov.spring_mvc_hibernate_aop.aspect;

import com.kirillsoklakov.spring_mvc_hibernate_aop.entity.Employee;
import javassist.bytecode.SignatureAttribute;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.kirillsoklakov.spring_mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();
        System.out.println("Begin of: " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of: " + methodName);

        return targetMethodResult;

    }
}
