package com.crayon.kk.injection;


import org.springframework.stereotype.Component;

@Component
public class InjectionServiceA {

    private InjectionServiceB serviceB;

    public void setServiceB(InjectionServiceB serviceB){
        this.serviceB=serviceB;
        System.out.println("A里面设置了B");

    }
}
