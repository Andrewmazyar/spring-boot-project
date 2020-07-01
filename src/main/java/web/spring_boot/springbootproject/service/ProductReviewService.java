package web.spring_boot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.spring_boot.springbootproject.entity.ProductReview;

public interface ProductReviewService {
    public ProductReview add(ProductReview productReview);

    public List<ProductReview> getAll();

    public Optional<ProductReview> getById(Long id);
}
