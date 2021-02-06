package com.crayon.kk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADmeoTest {

    static AtomicReference<Integer> reference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            reference.compareAndSet(100, 101);
            reference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reference.compareAndSet(100, 2021);
            System.out.println(Thread.currentThread().getName() + reference.get());
        }, "t2_").start();
        System.out.println("=========ABA=========");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + stampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            stampedReference.compareAndSet(101, 100, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        }, "t3_").start();

        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + stampedReference.getReference());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100, 2021, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + stampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + stampedReference.getReference());
        }, "t4_").start();
    }

}
