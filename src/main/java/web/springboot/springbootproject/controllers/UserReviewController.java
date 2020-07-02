package web.springboot.springbootproject.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.springboot.springbootproject.controllers.mappers.UserReviewMapper;
import web.springboot.springbootproject.dto.UserReviewDto;
import web.springboot.springbootproject.service.UserReviewService;

@RestController
@RequestMapping("/users-reviews")
public class UserReviewController {
    private final UserReviewMapper userReviewMapper;
    private final UserReviewService userReviewService;

    public UserReviewController(UserReviewMapper userReviewMapper,
                                UserReviewService userReviewService) {
        this.userReviewMapper = userReviewMapper;
        this.userReviewService = userReviewService;
    }

    @RequestMapping
    public List<UserReviewDto> getAll() {
        return userReviewService.getAll()
                .stream()
                .map(userReviewMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void add(@RequestBody UserReviewDto userReviewDto) {
        userReviewMapper.convertToObject(userReviewDto);
    }
}
