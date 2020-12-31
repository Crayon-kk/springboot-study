package com.crayon.kk.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DefaultSingletonBeanRegistry
 * 通过这个类进行三级缓存解决循环依赖
 */
public class ClientTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationfile.xml");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        A a = context.getBean("a",A.class);
        B b = context.getBean("b",B.class);
        // 这句将输出: hello world
    }
}
