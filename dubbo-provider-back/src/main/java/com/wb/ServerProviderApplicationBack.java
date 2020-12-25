package com.wb;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 模拟provider 多台部署
 */
@SpringBootApplication
@DubboComponentScan("com.wb")
public class ServerProviderApplicationBack {

    public static void main(String[] args) {
        SpringApplication.run(ServerProviderApplicationBack.class, args);
    }

}
