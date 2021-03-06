package web.springboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.springboot.springbootproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
