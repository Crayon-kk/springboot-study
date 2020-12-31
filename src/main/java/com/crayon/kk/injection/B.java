package com.crayon.kk.injection;

public class B {

    private A a;

    public B() {
        System.out.println("B success!");
    }

    public B(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
