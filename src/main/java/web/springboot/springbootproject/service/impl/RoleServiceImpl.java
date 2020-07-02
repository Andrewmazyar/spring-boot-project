package web.springboot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.entity.Role;
import web.springboot.springbootproject.repository.RoleRepository;
import web.springboot.springbootproject.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(Long id) {
        return roleRepository.findById(id);
    }
}
