package com.learning.java.aop;


import com.learning.java.aop.annotation.Compare;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CompareAspect {

    @Pointcut("@annotation(com.learning.java.aop.annotation.Compare)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        // 1.方法执行前的处理，相当于前置通知
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取方法上面的注解
        Compare compare = method.getAnnotation(Compare.class);
        // 获取操作描述的属性值
        String operateType = compare.type();

        System.out.println("前");
        result = joinPoint.proceed();
        System.out.println("后");
        return result;
    }

}
