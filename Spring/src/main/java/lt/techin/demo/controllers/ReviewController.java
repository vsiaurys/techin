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
}
