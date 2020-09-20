package cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName : Application5001
 * @Author : yq
 * @Date: 2020-09-20
 * @Description : eureka注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class Application5001 {

    public static void main(String[] args) {
        SpringApplication.run(Application5001.class, args);
    }
}
