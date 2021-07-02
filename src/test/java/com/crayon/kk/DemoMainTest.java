package com.crayon.kk;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 *
 *
 * @Author 张海锋
 * @Date 2021/7/2 16:38
 */
public class DemoMainTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //3
        System.out.println("中".getBytes(StandardCharsets.UTF_8).length);
        //6
        System.out.println("中中".getBytes(StandardCharsets.UTF_8).length);
        //1
        System.out.println("中".getBytes(StandardCharsets.US_ASCII).length);
        //2
        System.out.println("中".getBytes("GBK").length);
        //4
        System.out.println("中中".getBytes("GBK").length);
    }
}
