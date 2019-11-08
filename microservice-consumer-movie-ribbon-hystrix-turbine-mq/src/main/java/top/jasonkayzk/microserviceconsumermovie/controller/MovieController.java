package top.jasonkayzk.microserviceconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

@RestController
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    public MovieController(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

//    @HystrixCommand(fallbackMethod = "findByIdFallBack", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
//        @HystrixProperty(name = "metrics.rollingStats.timeoutInMilliseconds", value = "10000")
//    }, threadPoolProperties = {
//        @HystrixProperty(name = "coreSize", value = "1"),
//        @HystrixProperty(name = "maxQueueSize", value = "10")
//    })
//    @HystrixCommand(fallbackMethod = "findByIdFallBack")

    @HystrixCommand(fallbackMethod = "findByIdFallBack", ignoreExceptions = {
        IllegalArgumentException.class
    })
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    public User findByIdFallBack(Long id, Throwable throwable) {
        logger.error("进入回退方法, 异常: ", throwable);
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    /**
     * 日志记录当前选择的是那个节点
     *
     * this.loadBalancerClient.choose不可放在this.restTemplate.getForObject中:
     *
     * 因为理论上this.restTemplate.getForObject内部包括了Ribbon客户端, 即也会调用this.loadBalancerClient.choose!
     *
     */
    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");

        // 打印当前选择的是那个节点
        MovieController.logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
