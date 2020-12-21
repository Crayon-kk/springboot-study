package com.crayon.kk.injection;


import org.springframework.stereotype.Component;

@Component
public class InjectionServiceB {

    private InjectionServiceA serviceA;

    public void setServiceA(InjectionServiceA serviceA) {
        this.serviceA = serviceA;
        System.out.println("B里面设置了A");
    }

}
