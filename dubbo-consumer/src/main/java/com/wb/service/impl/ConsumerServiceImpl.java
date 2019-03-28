package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wb.dto.UserInfoDto;
import com.wb.service.IConsumerService;
import com.wb.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements IConsumerService {

    @Reference(url = "dubbo://192.168.1.166:20880")
    private IUserService userService;

    @Override
    public String getUserInfo(int userId) {
        UserInfoDto userInfoDto = userService.getUserInfo(userId);
        if(userInfoDto != null) {
            return userInfoDto.toString();
        }
        return "查询不到这个同学哦。。。" + userId;
    }
}
