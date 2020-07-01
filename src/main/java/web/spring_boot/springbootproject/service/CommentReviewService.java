package web.spring_boot.springbootproject.service;

import java.util.List;
import java.util.Optional;
import web.spring_boot.springbootproject.entity.CommentReview;

public interface CommentReviewService {
    public CommentReview add(CommentReview commentReview);

    public List<CommentReview> getAll();

    public Optional<CommentReview> getById(Long id);
}
