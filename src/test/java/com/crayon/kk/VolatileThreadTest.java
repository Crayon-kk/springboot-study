package com.crayon.kk;
 
 
import java.util.concurrent.TimeUnit;
 
 
/**
 * Violate 验证 Violate的可见性 
 */
public class VolatileThreadTest
{
    public static void main(String[] args)
    {
        Mydata mydata = new Mydata();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " com in");
            try
            {
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            mydata.addTo60();
            System.out.println(
                Thread.currentThread().getName() + " change number to " + mydata.number);
        }, "AAA").start();
        // 用于判断number的值有没有改变,此线程为main线程
        while (mydata.number == 0)
        {
        }
        // 主线程
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
 
 
class Mydata
{
    // int number = 0;
     int number = 0;
 
    public void addTo60()
    {
        this.number = 60;
    }
}