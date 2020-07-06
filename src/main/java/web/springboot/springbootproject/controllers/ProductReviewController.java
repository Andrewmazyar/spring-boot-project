package web.springboot.springbootproject.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.springboot.springbootproject.controllers.mappers.ProductReviewMapper;
import web.springboot.springbootproject.dto.ProductReviewDto;
import web.springboot.springbootproject.service.ProductReviewService;

@RestController
@RequestMapping("/products")
public class ProductReviewController {
    private final ProductReviewService productReviewService;
    private final ProductReviewMapper productReviewMapper;

    public ProductReviewController(ProductReviewService productReviewService,
                                   ProductReviewMapper productReviewMapper) {
        this.productReviewService = productReviewService;
        this.productReviewMapper = productReviewMapper;
    }

    @RequestMapping
    public List<ProductReviewDto> getAll() {
        return productReviewService.getAll()
                .stream()
                .map(productReviewMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void add(@RequestBody ProductReviewDto productReviewDto) {
        productReviewMapper.convertToObject(productReviewDto);
    }
}
