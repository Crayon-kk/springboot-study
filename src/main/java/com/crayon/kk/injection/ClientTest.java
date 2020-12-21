package com.crayon.kk.injection;

/**
 * DefaultSingletonBeanRegistry
 * 通过这个类进行三级缓存解决循环依赖
 */
public class ClientTest {
    public static void main(String[] args) {
        InjectionServiceA a = new InjectionServiceA();

        InjectionServiceB b = new InjectionServiceB();

        a.setServiceB(b);
        b.setServiceA(a);
    }
}
