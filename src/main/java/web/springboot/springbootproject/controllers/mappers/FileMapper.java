package web.springboot.springbootproject.controllers.mappers;

import org.springframework.stereotype.Component;
import web.springboot.springbootproject.dto.FileDto;
import web.springboot.springbootproject.entity.CommentReview;
import web.springboot.springbootproject.entity.ProductReview;
import web.springboot.springbootproject.entity.UserReview;

@Component
public class FileMapper {
    public UserReview convertToUser(FileDto fileDto) {
        UserReview userReview = new UserReview();
        userReview.setNickName(fileDto.getProfileName());
        userReview.setId(fileDto.getUserId());
        return userReview;
    }

    public ProductReview convertToProduct(FileDto fileDto) {
        ProductReview productReview = new ProductReview();
        productReview.setProductId(fileDto.getProductId());
        productReview.setScore(fileDto.getScore());
        productReview.setSummary(fileDto.getSummary());
        return productReview;
    }

    public CommentReview convertToComment(FileDto fileDto) {
        CommentReview commentReview = new CommentReview();
        commentReview.setText(fileDto.getText());
        commentReview.setProductReview(convertToProduct(fileDto));
        commentReview.setUserReview(convertToUser(fileDto));
        return commentReview;
    }
}
