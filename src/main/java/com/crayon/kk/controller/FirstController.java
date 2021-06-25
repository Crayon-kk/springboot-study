package com.crayon.kk.controller;

import com.crayon.kk.zk.DistributedLockByCurator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 75510
 */
@RestController
@RequestMapping("/first")
public class FirstController {

//    private final DistributedLockByCurator curator;
//
//    public FirstController(DistributedLockByCurator curator) {
//        this.curator = curator;
//    }

    @GetMapping("/query.do")
    public String first() {

        return "hello world";
    }

//    @GetMapping("/test01.do")
//    public boolean lock() {
//        curator.acquireLock("test02");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        return curator.releaseLock("test02");
//    }
//
//    @GetMapping("/test02.do")
//    public boolean lock2()  {
//        curator.acquireLock("test02");
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        return curator.releaseLock("test02");
//    }
}
