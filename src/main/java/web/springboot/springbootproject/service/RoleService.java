package web.springboot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.springboot.springbootproject.entity.Role;

public interface RoleService {
    public Role add(Role role);

    public List<Role> getAll();

    public Optional<Role> getById(Long id);
}
