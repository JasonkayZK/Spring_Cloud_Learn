package top.jasonkayzk.microserviceconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.jasonkayzk.config.FeignLogConfig;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

@FeignClient(name = "microservice-provider-user", configuration = FeignLogConfig.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
