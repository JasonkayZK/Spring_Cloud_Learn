package top.jasonkayzk.microservicesimpleprovideruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jasonkayzk.microservicesimpleprovideruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
