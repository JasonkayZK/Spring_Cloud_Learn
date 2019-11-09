package top.jasonkayzk.microservicesidecarclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceSidecarClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSidecarClientApplication.class, args);
    }

}
