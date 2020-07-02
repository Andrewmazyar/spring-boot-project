package web.springboot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.springboot.springbootproject.entity.UserReview;

public interface UserReviewService {

    public UserReview add(UserReview userReview);

    public List<UserReview> getAll();

    public Optional<UserReview> getById(Long id);
}
