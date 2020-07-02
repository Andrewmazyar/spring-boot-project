package web.springboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.springboot.springbootproject.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
