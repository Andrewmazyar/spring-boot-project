package web.springboot.springbootproject.controllers.mappers;

import org.springframework.stereotype.Component;
import web.springboot.springbootproject.dto.UserReviewDto;
import web.springboot.springbootproject.entity.UserReview;
import web.springboot.springbootproject.service.UserReviewService;

@Component
public class UserReviewMapper {
    private final UserReviewService userReviewService;

    public UserReviewMapper(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    public UserReviewDto convertToDto(UserReview userReview) {
        UserReviewDto dto = new UserReviewDto();
        dto.setNickname(userReview.getNickName());
        return dto;
    }

    public UserReview convertToObject(UserReviewDto userReviewDto) {
        UserReview userReview = new UserReview();
        userReview.setNickName(userReviewDto.getNickname());
        return userReviewService.add(userReview);
    }
}
