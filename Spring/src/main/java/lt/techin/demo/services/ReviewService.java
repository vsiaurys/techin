package lt.techin.demo.services;

import lt.techin.demo.models.Review;
import lt.techin.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public Review findReviewById(long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    public Review saveReview(Review review) {
        return this.reviewRepository.save(review);
    }

    public boolean existsReviewById(long id) {
        return this.reviewRepository.existsById(id);
    }

    public void deleteReviewById(long id) {
        this.reviewRepository.deleteById(id);
    }
}
