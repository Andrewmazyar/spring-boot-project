package web.spring_boot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.entity.UserReview;
import web.spring_boot.springbootproject.repository.UserRepository;
import web.spring_boot.springbootproject.service.UserReviewService;

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
