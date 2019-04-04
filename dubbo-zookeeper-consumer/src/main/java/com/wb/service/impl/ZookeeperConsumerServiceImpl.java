package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wb.dto.UserInfoDto;
import com.wb.service.IUserService;
import com.wb.service.IZookeeperConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ZookeeperConsumerServiceImpl implements IZookeeperConsumerService {

    @Reference
    private IUserService userService;

//    @Reference
//    private IMessageService messageService;

    @Override
    public String getUserInfo(int userId) {
        UserInfoDto userInfoDto = userService.getUserInfo(userId);
        if(userInfoDto != null) {
            return userInfoDto.toString();
        }
        return "查询不到这个同学哦。。。" + userId;
    }

    @Override
    public String sendMsg(String msg) {
//        boolean success = messageService.sendMsg(msg);
//        if (success) {
//            return "信息发送成功";
//        }
        return "信息发送失败";
    }
}
