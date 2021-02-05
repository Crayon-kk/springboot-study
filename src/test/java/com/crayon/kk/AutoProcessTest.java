package com.crayon.kk;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoProcessTest {

    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(5);
        //当期望值和原始值相等时，则进行更改
        //expect 期望值 update 修改值
        boolean b = integer.compareAndSet(5, 2021);
        System.out.println(b);
        System.out.println(integer);

        integer.getAndIncrement();

    }
}
