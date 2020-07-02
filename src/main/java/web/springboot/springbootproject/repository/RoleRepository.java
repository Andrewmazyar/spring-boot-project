package web.springboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.springboot.springbootproject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
