package web.springboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.springboot.springbootproject.entity.CommentReview;

public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {
}
