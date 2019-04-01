package com.wb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wb.service.IMessageService;
import org.springframework.stereotype.Component;

@Service
@Component
public class MessageServiceImpl implements IMessageService {

    @Override
    public boolean sendMsg(String msg) {
        System.out.println(msg);
        return true;
    }
}
