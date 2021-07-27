package com.content;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @ClassName : ContentAutoConfig
 * @Author : yq
 * @Date: 2021-07-27
 * @Description :
 */

@Configuration
@ComponentScan(basePackages = {"com.content"})
@EnableMongoRepositories(basePackages = {"com.content.repository"})
public class ContentAutoConfig {



}
