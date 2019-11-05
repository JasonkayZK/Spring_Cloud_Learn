package top.jasonkayzk.microserviceconsumermovie.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

import java.util.List;

@RestController
public class MovieController {

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public MovieController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }

    /**
     * 查询microservice-provider-user服务的信息并返回
     * @return microservice-provider-user服务的信息
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }

}
