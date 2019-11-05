package top.jasonkayzk.microservicediscoveryeurekaauthenticating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka微服务发现
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceDiscoveryEurekaAuthenticatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDiscoveryEurekaAuthenticatingApplication.class, args);
    }

}
