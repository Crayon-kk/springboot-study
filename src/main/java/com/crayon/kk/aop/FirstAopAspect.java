package com.crayon.kk.aop;

import com.crayon.kk.annotation.AopAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * aop测试
 */
@Aspect
@Component
public class FirstAopAspect {
    private static final Logger LOG = LoggerFactory.getLogger(FirstAopAspect.class);

    @Pointcut("@annotation(com.crayon.kk.annotation.AopAnnotation)")
    public void pointCut(){}

    /**
     * 环绕通知
     *
     * @param point
     * @param param
     * @throws Throwable
     */
    @Around(value = "pointCut()&&@annotation(param)",argNames = "point,param")
    public void before(ProceedingJoinPoint point, AopAnnotation param) throws Throwable{

        System.out.println(param.value());

        //执行原方法
        point.proceed();

        System.out.println("end");

    }

}
