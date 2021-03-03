package com.crayon.kk;

public class AutoProcessTest {

    public static void main(String[] args) throws Exception{
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        String str2 = "he" + new String("llo");

        System.out.println(str2);

//        String s1 = "java";
//        String s2 = "web";
//        String s3 = "javaweb";
//        String s4 = "java"+"web";
//        System.out.println(s3==s4);
//        System.out.println(s3==s1+s2);
//
//        String a = new String("1");
//        a.intern();
//        String a1 = "1";
//        System.out.println(a==a1);
//
//        String a2 = new String("1") + new String("1");
//        a2.intern();
//        String a3 = "11";
//        System.out.println(a2==a3);

    }
}
