package web.spring_boot.springbootproject.controllers;

import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import web.spring_boot.springbootproject.controllers.mappers.MapperFileDtoToObject;
import web.spring_boot.springbootproject.dto.FileDto;
import web.spring_boot.springbootproject.entity.CommentReview;
import web.spring_boot.springbootproject.service.CommentReviewService;
import web.spring_boot.springbootproject.service.ParseService;
import web.spring_boot.springbootproject.service.ProductReviewService;
import web.spring_boot.springbootproject.service.UserReviewService;

public class InjectDataController {
    private final String ROUTE = "/home/user/IdeaProjects/Reviews.csv";

    private final ParseService parseService;
    private final MapperFileDtoToObject mapperFileDtoToObject;
    private final UserReviewService userReviewService;
    private final ProductReviewService productReviewService;
    private final CommentReviewService commentReviewService;

    public InjectDataController(ParseService parseService,
                                MapperFileDtoToObject mapperFileDtoToObject,
                                UserReviewService userReviewService,
                                ProductReviewService productReviewService,
                                CommentReviewService commentReviewService) {
        this.parseService = parseService;
        this.mapperFileDtoToObject = mapperFileDtoToObject;
        this.userReviewService = userReviewService;
        this.productReviewService = productReviewService;
        this.commentReviewService = commentReviewService;
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        for (FileDto fileDto : parseService.parse(ROUTE)) {
            CommentReview commentReview = mapperFileDtoToObject.convertToComment(fileDto);
            productReviewService.add(commentReview.getProductReview());
            userReviewService.add(commentReview.getUserReview());
            commentReviewService.add(commentReview);
        }

    }
}
