package com.wb.controller;

import com.wb.service.IZookeeperConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZookeeperConsumerController {

    @Autowired
    IZookeeperConsumerService zookeeperConsumerService;

    @RequestMapping("/hi")
    String sayHi(@RequestParam int userId){
        return zookeeperConsumerService.getUserInfo(userId);
    }

    @RequestMapping("/msg")
    String sendMsg(@RequestParam String msg){
        return zookeeperConsumerService.sendMsg(msg);
    };

}
