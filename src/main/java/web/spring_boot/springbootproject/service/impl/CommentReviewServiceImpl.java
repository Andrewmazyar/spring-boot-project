package web.spring_boot.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import web.spring_boot.springbootproject.entity.CommentReview;
import web.spring_boot.springbootproject.repository.CommentReviewRepository;
import web.spring_boot.springbootproject.service.CommentReviewService;

@Service
public class CommentReviewServiceImpl implements CommentReviewService {
    private final CommentReviewRepository commentReviewRepository;

    public CommentReviewServiceImpl(CommentReviewRepository commentReviewRepository) {
        this.commentReviewRepository = commentReviewRepository;
    }

    @Override
    public CommentReview add(CommentReview commentReview) {
        return commentReviewRepository.save(commentReview);
    }

    @Override
    public List<CommentReview> getAll() {
        return commentReviewRepository.findAll();
    }

    @Override
    public Optional<CommentReview> getById(Long id) {
        return commentReviewRepository.findById(id);
    }
}
