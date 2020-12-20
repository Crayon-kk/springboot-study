package com.crayon.kk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {


    @RequestMapping("/query.do")
    public String first(){

        return "hello world";
    }
}
