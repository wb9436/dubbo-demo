package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wb.dto.UserInfoDto;
import com.wb.service.IUserService;
import org.springframework.stereotype.Component;

@Service        //非spring 暴露服务
@Component
public class UserServiceImpl implements IUserService{

    @Override
    public UserInfoDto getUserInfo(int userId) {
        UserInfoDto userInfoDto = new UserInfoDto(userId, "小明" + userId);
        userInfoDto.setVersion("Service: " + "2.0");
        return userInfoDto;
    }
}
