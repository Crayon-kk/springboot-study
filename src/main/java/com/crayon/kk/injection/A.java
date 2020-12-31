package com.crayon.kk.injection;

public class A {
    private B b;

    public A() {
        System.out.println("A success!");
    }

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
