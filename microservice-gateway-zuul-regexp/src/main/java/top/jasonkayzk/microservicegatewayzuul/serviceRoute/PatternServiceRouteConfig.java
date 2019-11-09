package top.jasonkayzk.microservicegatewayzuul.serviceRoute;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatternServiceRouteConfig {

    // 调用构造函数PatternServiceRouteMapper(String servicePattern, String routePattern)
    // servicePattern指定微服务的正则
    // routePattern指定路由正则
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }

}
