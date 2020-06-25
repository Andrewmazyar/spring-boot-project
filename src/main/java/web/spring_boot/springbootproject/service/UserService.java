package web.spring_boot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.spring_boot.springbootproject.entity.User;

public interface UserService {

    public User add(User user);

    public List<User> getAll();

    public Optional<User> getById(Long id);
}
