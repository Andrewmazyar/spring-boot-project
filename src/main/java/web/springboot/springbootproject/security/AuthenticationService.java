package web.springboot.springbootproject.security;

import web.springboot.springbootproject.entity.User;

public interface AuthenticationService {
    public User register(String username, String password);
}
