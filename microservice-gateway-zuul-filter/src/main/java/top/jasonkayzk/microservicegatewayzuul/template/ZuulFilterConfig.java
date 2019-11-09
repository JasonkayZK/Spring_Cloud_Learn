package top.jasonkayzk.microservicegatewayzuul.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jasonkayzk.microservicegatewayzuul.filter.PreRequestLogFilter;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }

}
