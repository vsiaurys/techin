package lt.techin.demo.controllers;

import lt.techin.demo.models.Movie;
import lt.techin.demo.models.Review;
import lt.techin.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return this.reviewRepository.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @PostMapping("/reviews")
    public void insertReview(@RequestBody Review review) {
        this.reviewRepository.save(review);
    }
    @PutMapping("/reviews/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable long id) {
        if (this.reviewRepository.existsById(id)) {
            Review reviewFromDb = this.reviewRepository.findById(id).orElseThrow();

            reviewFromDb.setMovie(review.getMovie());
            reviewFromDb.setReview(review.getReview());
            reviewFromDb.setAuthor(review.getAuthor());
            reviewFromDb.setRating(review.getRating());
            reviewFromDb.setReviewDate(review.getReviewDate());

            return this.reviewRepository.save(reviewFromDb);
        }
        return this.reviewRepository.save(review);
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable long id) {
        this.reviewRepository.deleteById(id);
    }
}
