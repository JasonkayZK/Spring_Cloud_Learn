package top.jasonkayzk.microserviceconsumermovie.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.jasonkayzk.config.FeignConfig;
import top.jasonkayzk.microserviceconsumermovie.entity.User;

/**
 * 使用@FeignClient的configuration属性，指定feign的配置类。
 *
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfig.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解@RequestLine
     * @see https://github.com/OpenFeign/feign
     * @param id 用户id
     * @return 用户信息
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
