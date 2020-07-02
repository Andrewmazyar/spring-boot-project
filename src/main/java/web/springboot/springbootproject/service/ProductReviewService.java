package web.springboot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.springboot.springbootproject.entity.ProductReview;

public interface ProductReviewService {
    public ProductReview add(ProductReview productReview);

    public List<ProductReview> getAll();

    public Optional<ProductReview> getById(Long id);
}
