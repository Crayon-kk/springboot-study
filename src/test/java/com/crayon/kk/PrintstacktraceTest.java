package com.crayon.kk;

import java.util.concurrent.TimeUnit;

/**
 * @Author 张海锋
 * @Date 2021/6/1 10:01
 */
public class PrintstacktraceTest {

    public static void main(String[] args) throws InterruptedException {

        try {
            printTest();
        } catch (Exception e) {
            e.printStackTrace();
            TimeUnit.MINUTES.sleep(5);

        }


    }
    public static void printTest() throws Exception {

        throw new Exception("手动抛异常");
    }
}
