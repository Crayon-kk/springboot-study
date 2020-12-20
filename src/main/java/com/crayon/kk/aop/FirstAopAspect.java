package com.crayon.kk.aop;

import com.crayon.kk.annotation.AopAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAopAspect {
    private static final Logger LOG = LoggerFactory.getLogger(FirstAopAspect.class);

    @Pointcut("@annotation(com.crayon.kk.annotation.AopAnnotation)")
    public void pointCut(){}

    @Around(value = "pointCut()&&@annotation(param)",argNames = "point,param")
    public void before(ProceedingJoinPoint point, AopAnnotation param) throws Throwable{

        System.out.println(param.value());

        point.proceed();

        System.out.println("end");

    }

}
