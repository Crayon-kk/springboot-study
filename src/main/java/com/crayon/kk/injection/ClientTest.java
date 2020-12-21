package com.crayon.kk.injection;

public class ClientTest {
    public static void main(String[] args) {
        InjectionServiceA a = new InjectionServiceA();

        InjectionServiceB b = new InjectionServiceB();

        a.setServiceB(b);
        b.setServiceA(a);
    }
}
