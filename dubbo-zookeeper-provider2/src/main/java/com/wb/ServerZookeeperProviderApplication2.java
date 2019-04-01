package com.wb;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.wb")
public class ServerZookeeperProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ServerZookeeperProviderApplication2.class, args);
    }

}
