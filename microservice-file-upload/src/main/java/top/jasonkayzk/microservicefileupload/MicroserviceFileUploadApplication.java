package top.jasonkayzk.microservicefileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFileUploadApplication.class, args);
    }

}
