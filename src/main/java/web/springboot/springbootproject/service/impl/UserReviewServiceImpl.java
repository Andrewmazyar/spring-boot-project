package web.springboot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.entity.UserReview;
import web.springboot.springbootproject.repository.UserRepository;
import web.springboot.springbootproject.service.UserReviewService;

@Service
public class UserReviewServiceImpl implements UserReviewService {
    private final UserRepository userRepository;

    public UserReviewServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserReview add(UserReview userReview) {
        return userRepository.save(userReview);
    }

    @Override
    public List<UserReview> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserReview> getById(Long id) {
        return userRepository.findById(id);
    }
}
