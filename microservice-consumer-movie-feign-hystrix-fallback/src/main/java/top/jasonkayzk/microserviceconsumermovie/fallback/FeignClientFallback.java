package top.jasonkayzk.microserviceconsumermovie.fallback;

import org.springframework.stereotype.Component;
import top.jasonkayzk.microserviceconsumermovie.entity.User;
import top.jasonkayzk.microserviceconsumermovie.feign.UserFeignClient;

/**
 * 回退类FeignClientFallback需要实现Feign Client接口
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

}
