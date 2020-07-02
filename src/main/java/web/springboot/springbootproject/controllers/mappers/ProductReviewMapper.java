package web.springboot.springbootproject.controllers.mappers;

import org.springframework.stereotype.Component;
import web.springboot.springbootproject.dto.ProductReviewDto;
import web.springboot.springbootproject.entity.ProductReview;
import web.springboot.springbootproject.service.ProductReviewService;

@Component
public class ProductReviewMapper {
    private final ProductReviewService productReviewService;

    public ProductReviewMapper(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    public ProductReviewDto convertToDto(ProductReview productReview) {
        ProductReviewDto dto = new ProductReviewDto();
        dto.setScore(productReview.getScore());
        dto.setSummary(productReview.getSummary());
        return dto;
    }

    public ProductReview convertToObject(ProductReviewDto productReviewDto) {
        ProductReview productReview = new ProductReview();
        productReview.setScore(productReview.getScore());
        productReview.setSummary(productReviewDto.getSummary());
        return productReviewService.add(productReview);
    }
}
