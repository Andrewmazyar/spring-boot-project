package web.springboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.springboot.springbootproject.entity.UserReview;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
