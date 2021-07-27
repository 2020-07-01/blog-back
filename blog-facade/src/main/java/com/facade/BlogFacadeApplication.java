package com.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @ClassName : BlogFacadeApplication
 * @Author : yq
 * @Date: 2021-07-27
 * @Description :
 */
@EnableConfigurationProperties
@SpringBootApplication
public class BlogFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogFacadeApplication.class);
    }

}
