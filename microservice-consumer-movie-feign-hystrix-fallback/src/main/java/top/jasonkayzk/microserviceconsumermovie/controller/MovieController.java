package top.jasonkayzk.microserviceconsumermovie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.microserviceconsumermovie.entity.User;
import top.jasonkayzk.microserviceconsumermovie.feign.UserFeignClient;

@RestController
public class MovieController {

    private final UserFeignClient userFeignClient;

    public MovieController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

}
