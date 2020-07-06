package web.springboot.springbootproject.controllers;

import javax.annotation.PostConstruct;
import java.util.Set;
import lombok.SneakyThrows;
import web.springboot.springbootproject.controllers.mappers.FileMapper;
import web.springboot.springbootproject.dto.FileDto;
import web.springboot.springbootproject.entity.CommentReview;
import web.springboot.springbootproject.entity.Role;
import web.springboot.springbootproject.entity.User;
import web.springboot.springbootproject.service.CommentReviewService;
import web.springboot.springbootproject.service.ParseService;
import web.springboot.springbootproject.service.ProductReviewService;
import web.springboot.springbootproject.service.RoleService;
import web.springboot.springbootproject.service.UserReviewService;
import web.springboot.springbootproject.service.UserService;

public class InjectDataController {
    private final String ROUTE = "/home/user/IdeaProjects/Reviews.csv";

    private final ParseService parseService;
    private final FileMapper fileMapper;
    private final UserReviewService userReviewService;
    private final ProductReviewService productReviewService;
    private final CommentReviewService commentReviewService;
    private final RoleService roleService;
    private final UserService userService;

    public InjectDataController(ParseService parseService,
                                FileMapper fileMapper,
                                UserReviewService userReviewService,
                                ProductReviewService productReviewService,
                                CommentReviewService commentReviewService,
                                RoleService roleService, UserService userService) {
        this.parseService = parseService;
        this.fileMapper = fileMapper;
        this.userReviewService = userReviewService;
        this.productReviewService = productReviewService;
        this.commentReviewService = commentReviewService;
        this.roleService = roleService;
        this.userService = userService;
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
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName((Role.RoleName.USER));
        roleService.add(userRole);
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        admin.setRoles(Set.of(userRole, adminRole));
        userService.add(admin);

    }
}
