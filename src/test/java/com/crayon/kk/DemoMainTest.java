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
        System.out.println("中".getBytes(StandardCharsets.UTF_8).length);
        System.out.println("中中".getBytes(StandardCharsets.UTF_8).length);
        System.out.println("中".getBytes("GBK").length);
        System.out.println("中中".getBytes("GBK").length);

        System.out.println("n".getBytes(StandardCharsets.UTF_8).length);
        System.out.println("nn".getBytes(StandardCharsets.UTF_8).length);
        System.out.println("n".getBytes("GBK").length);
        System.out.println("nn".getBytes("GBK").length);

    }
}

