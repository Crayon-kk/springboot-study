package com.crayon.kk.controller;

import com.crayon.kk.entity.UserInfo;
import com.crayon.kk.response.ResultResponse;
import com.crayon.kk.service.impl.MysqlConnectServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张海锋
 * @Date 2021/6/29 15:24
 */
@RestController
public class MysqlConnectController {

    private final MysqlConnectServiceImpl service;

    public MysqlConnectController(MysqlConnectServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/mysql")
    public ResultResponse<UserInfo> getUserInfo(){

        return ResultResponse.success(service.getUserInfos());
    }
}
