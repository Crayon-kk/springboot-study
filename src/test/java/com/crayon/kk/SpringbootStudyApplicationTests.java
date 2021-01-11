package com.crayon.kk;

import com.crayon.kk.service.impl.AopServiceImpl;
import com.crayon.kk.service.impl.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootStudyApplicationTests {

    @Autowired
    private AopServiceImpl aopService;

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Test
    public void aopTest() {
        aopService.processData(10, 2);
    }

    @Test
    public void arrayListTest() {
        //无参构造
        List<Integer> list = new ArrayList<>();
        //初始容量为0
        System.out.println(getArrayListCapacity(list));//0
        //添加一个元素后初始容量变为10
        list.add(1);
        System.out.println(getArrayListCapacity(list));//10

        //有参构造初始为0
        List<Integer> list1 = new ArrayList<>(2);
        //初始容量为0
        System.out.println(getArrayListCapacity(list1));//0
        //添加一个元素后初始容量变为1
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        System.out.println(getArrayListCapacity(list1));//1
    }

    public int getArrayListCapacity(List<Integer> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException e) {
            return -1;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Test
    public void beanInitTest(){
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
        Book book = (Book)context.getBean("book");
        System.out.println("Book name = " + book.getBookName());
        ((ClassPathXmlApplicationContext) context).destroy();

    }

}
