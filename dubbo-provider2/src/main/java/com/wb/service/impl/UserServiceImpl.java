package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wb.dto.UserInfoDto;
import com.wb.service.IUserService;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements IUserService {

    @Override
    public UserInfoDto getUserInfo(int userId) {
        return new UserInfoDto(userId, "小明" + userId);
    }

}
