package web.spring_boot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.spring_boot.springbootproject.entity.UserReview;

public interface UserReviewService {

    public UserReview add(UserReview userReview);

    public List<UserReview> getAll();

    public Optional<UserReview> getById(Long id);
}
