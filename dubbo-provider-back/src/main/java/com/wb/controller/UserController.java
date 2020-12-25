package com.wb.controller;

import com.wb.dto.UserInfoDto;
import com.wb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/hi")
    String sayHi(@RequestParam int userId) {
        UserInfoDto userInfoDto = userService.getUserInfo(userId);
        if(userInfoDto != null) {
            return "hi, " + userInfoDto.getUsername();
        }
        return "sorry, who you want ?";
    }

}
