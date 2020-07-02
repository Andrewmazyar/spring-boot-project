package web.springboot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.entity.UserReview;
import web.springboot.springbootproject.repository.UserReviewRepository;
import web.springboot.springbootproject.service.UserReviewService;

@Service
public class UserReviewServiceImpl implements UserReviewService {
    private final UserReviewRepository userReviewRepository;

    public UserReviewServiceImpl(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    @Override
    public UserReview add(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    @Override
    public List<UserReview> getAll() {
        return userReviewRepository.findAll();
    }

    @Override
    public Optional<UserReview> getById(Long id) {
        return userReviewRepository.findById(id);
    }
}
