package web.springboot.springbootproject.controllers;

import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import web.springboot.springbootproject.controllers.mappers.FileMapper;
import web.springboot.springbootproject.dto.FileDto;
import web.springboot.springbootproject.entity.CommentReview;
import web.springboot.springbootproject.service.CommentReviewService;
import web.springboot.springbootproject.service.ParseService;
import web.springboot.springbootproject.service.ProductReviewService;
import web.springboot.springbootproject.service.UserReviewService;

public class InjectDataController {
    private final String ROUTE = "/home/user/IdeaProjects/Reviews.csv";

    private final ParseService parseService;
    private final FileMapper fileMapper;
    private final UserReviewService userReviewService;
    private final ProductReviewService productReviewService;
    private final CommentReviewService commentReviewService;

    public InjectDataController(ParseService parseService,
                                FileMapper fileMapper,
                                UserReviewService userReviewService,
                                ProductReviewService productReviewService,
                                CommentReviewService commentReviewService) {
        this.parseService = parseService;
        this.fileMapper = fileMapper;
        this.userReviewService = userReviewService;
        this.productReviewService = productReviewService;
        this.commentReviewService = commentReviewService;
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        for (FileDto fileDto : parseService.parse(ROUTE)) {
            CommentReview commentReview = fileMapper.convertToComment(fileDto);
            productReviewService.add(commentReview.getProductReview());
            userReviewService.add(commentReview.getUserReview());
            commentReviewService.add(commentReview);
        }

    }
}
