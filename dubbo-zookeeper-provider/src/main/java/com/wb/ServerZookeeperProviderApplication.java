package com.wb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.wb.filter.ServiceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.wb")
public class ServerZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerZookeeperProviderApplication.class, args);
    }

    @Bean
    ServiceFilter serviceFilter() {
        return new ServiceFilter();
    }

}
