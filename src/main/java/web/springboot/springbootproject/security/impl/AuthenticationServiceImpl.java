package web.springboot.springbootproject.security.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.entity.User;
import web.springboot.springbootproject.security.AuthenticationService;
import web.springboot.springbootproject.service.RoleService;
import web.springboot.springbootproject.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setRoles(Set.of(roleService.getById(2L).get()));
        userService.add(user);
        return user;

    }
}
