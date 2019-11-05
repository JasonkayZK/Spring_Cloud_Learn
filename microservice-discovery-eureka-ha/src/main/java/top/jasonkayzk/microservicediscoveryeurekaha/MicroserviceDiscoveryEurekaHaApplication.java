package top.jasonkayzk.microservicediscoveryeurekaha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Profile;

/**
 * 使用Eureka微服务发现
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceDiscoveryEurekaHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDiscoveryEurekaHaApplication.class, args);
    }

}
