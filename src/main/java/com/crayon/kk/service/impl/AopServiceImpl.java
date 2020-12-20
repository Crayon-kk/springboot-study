package com.crayon.kk.service.impl;

import com.crayon.kk.annotation.AopAnnotation;
import org.springframework.stereotype.Component;

@Component
public class AopServiceImpl {

    /**
     * 测试aop
     *
     * @param x
     * @param y
     */
    @AopAnnotation(value = "测试")
    public void processData(int x, int y) {

        System.out.println(y / x);
    }
}
