package com.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : BlogFacadeApplication
 * @Author : yq
 * @Date: 2021-07-27
 * @Description :
 */
@EnableConfigurationProperties
@SpringBootApplication
@EnableDiscoveryClient
public class BlogFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogFacadeApplication.class);
    }

}
