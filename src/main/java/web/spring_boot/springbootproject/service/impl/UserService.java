package web.spring_boot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.entity.User;
import web.spring_boot.springbootproject.repository.UserRepository;
import web.spring_boot.springbootproject.service.UserServices;

@Service
public class UserService implements UserServices {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}
