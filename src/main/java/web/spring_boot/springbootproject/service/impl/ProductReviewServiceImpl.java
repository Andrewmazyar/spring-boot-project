package web.spring_boot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.entity.ProductReview;
import web.spring_boot.springbootproject.repository.ProductReviewRepository;
import web.spring_boot.springbootproject.service.ProductReviewService;

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
