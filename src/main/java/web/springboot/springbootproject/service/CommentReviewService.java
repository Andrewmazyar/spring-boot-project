package web.springboot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.springboot.springbootproject.entity.CommentReview;

public interface CommentReviewService {
    public CommentReview add(CommentReview commentReview);

    public List<CommentReview> getAll();

    public Optional<CommentReview> getById(Long id);
}
