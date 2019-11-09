package top.jasonkayzk.microservicegatewayzuul.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import top.jasonkayzk.microservicegatewayzuul.eneity.User;

@Service
public class AggregationService {

    private final RestTemplate restTemplate;

    public AggregationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackForProvider")
    public Observable<User> getUserById(Long id) {
        // 创建一个被观察者
        return Observable.create(observer -> {
            // 请求用户provider微服务的/{id}端点
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallbackForConsumer")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(observer -> {
            // 请求电影consumer微服务的/user/{id}端点
            User movieUser = restTemplate.getForObject("http://microservice-consumer-movie/user/{id}", User.class, id);
            observer.onNext(movieUser);
            observer.onCompleted();
        });
    }

    public User fallbackForProvider(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }

    public User fallbackForConsumer(Long id) {
        User user = new User();
        user.setId(-2L);
        return user;
    }


}
