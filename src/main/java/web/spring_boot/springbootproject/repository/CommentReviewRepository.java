package web.spring_boot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.spring_boot.springbootproject.entity.CommentReview;

public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {
}
