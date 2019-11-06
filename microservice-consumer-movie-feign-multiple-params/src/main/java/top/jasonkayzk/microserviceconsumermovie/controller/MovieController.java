package top.jasonkayzk.microserviceconsumermovie.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.microserviceconsumermovie.entity.User;
import top.jasonkayzk.microserviceconsumermovie.feign.UserFeignClient;

import java.util.Map;

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

    /**
     * 测试URL：http://localhost:8010/user/get0?id=1&username=张三
     * 该请求不会成功。
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return this.userFeignClient.get0(user);
    }


    /**
     * 测试URL：http://localhost:8010/user/get1?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get1")
    public User get1(User user) {
        return this.userFeignClient.get1(user.getId(), user.getUsername());
    }

    /**
     * 测试URL：http://localhost:8010/user/get2?id=1&username=张三&age=18
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("age", user.getAge());
        return this.userFeignClient.get2(map);
    }

    /**
     * 测试URL:http://localhost:8010/user/post?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/post")
    public User post(User user) {
        return this.userFeignClient.post(user);
    }

}
