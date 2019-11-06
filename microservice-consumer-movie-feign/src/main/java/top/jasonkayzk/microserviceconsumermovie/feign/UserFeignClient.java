package top.jasonkayzk.microserviceconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

//@FeignClient(name = "microservice-provider-user", url = "http://localhost:8000/")
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
