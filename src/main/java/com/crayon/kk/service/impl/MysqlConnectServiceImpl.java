package com.crayon.kk.service.impl;

import com.crayon.kk.entity.UserInfo;
import com.crayon.kk.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 张海锋
 * @Date 2021/6/29 15:22
 */
@Service
public class MysqlConnectServiceImpl {

    private final UserInfoMapper mapper;

    public MysqlConnectServiceImpl(UserInfoMapper mapper) {
        this.mapper = mapper;
    }

    public UserInfo getUserInfos(){

        return mapper.selectByPrimaryKey(1L);
    }
}
