//package top.jasonkayzk.microservicesimpleprovideruser.config;
//
//import com.netflix.discovery.DiscoveryClient;
//import com.sun.jersey.api.client.filter.ClientFilter;
//import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class EurekaDiscoveryConfig {
//
//    @Bean
//    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
//        DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs = new DiscoveryClient.DiscoveryClientOptionalArgs();
//        List<ClientFilter> additionalFilters = new ArrayList<>();
//        additionalFilters.add(new HTTPBasicAuthFilter("zk", "zk137818"));
//        discoveryClientOptionalArgs.setAdditionalFilters(additionalFilters);
//        return discoveryClientOptionalArgs;
//    }
//
//}
