package web.springboot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.springboot.springbootproject.entity.ProductReview;
import web.springboot.springbootproject.repository.ProductReviewRepository;
import web.springboot.springbootproject.service.ProductReviewService;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {
    private final ProductReviewRepository productReviewRepository;

    public ProductReviewServiceImpl(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    @Override
    public ProductReview add(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    public List<ProductReview> getAll() {
        return productReviewRepository.findAll();
    }

    @Override
    public Optional<ProductReview> getById(Long id) {
        return productReviewRepository.findById(id);
    }
}
