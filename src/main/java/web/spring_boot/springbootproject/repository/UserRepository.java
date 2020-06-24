package web.spring_boot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.spring_boot.springbootproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
