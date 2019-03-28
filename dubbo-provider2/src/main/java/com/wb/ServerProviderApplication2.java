package com.wb;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.wb")
public class ServerProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ServerProviderApplication2.class, args);
    }

}
