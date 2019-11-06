package top.jasonkayzk.microservicesimpleprovideruser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.microservicesimpleprovideruser.entity.User;
import top.jasonkayzk.microservicesimpleprovideruser.repository.UserRepository;

import java.util.Collection;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority c : collection) {
                UserController.LOGGER.info("当前用户是{}, 角色是{}", user.getUsername(), c.getAuthority());
            }
        } else {
            // do other things
        }
        return this.userRepository.findOne(id);
    }

}
