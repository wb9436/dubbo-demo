package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wb.dao.UserInfoDao;
import com.wb.dto.UserInfoDto;
import com.wb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service        //非spring 暴露服务
@Component
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoDto getUserInfo(int userId) {
        return userInfoDao.getUserById(userId);
    }
}
