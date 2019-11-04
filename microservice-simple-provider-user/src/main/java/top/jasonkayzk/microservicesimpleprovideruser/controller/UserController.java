package top.jasonkayzk.microservicesimpleprovideruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.microservicesimpleprovideruser.entity.User;
import top.jasonkayzk.microservicesimpleprovideruser.repository.UserRepository;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

}
