package top.jasonkayzk.microserviceconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

import java.util.Map;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    // 该请求不会成功!
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get0(User user);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get2(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    User post(@RequestBody User user);

}
