package web.spring_boot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.spring_boot.springbootproject.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
