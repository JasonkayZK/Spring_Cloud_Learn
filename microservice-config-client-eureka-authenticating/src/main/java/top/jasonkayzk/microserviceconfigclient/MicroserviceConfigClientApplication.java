package top.jasonkayzk.microserviceconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigClientApplication.class, args);
    }

}
