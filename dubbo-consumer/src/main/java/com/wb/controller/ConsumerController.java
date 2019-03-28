package com.wb.controller;

import com.wb.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    IConsumerService consumerService;

    @RequestMapping("/hi")
    String sayHi(@RequestParam int userId){
        return consumerService.getUserInfo(userId);
    }

}
