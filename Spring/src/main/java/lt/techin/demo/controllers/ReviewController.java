package lt.techin.demo.controllers;

import lt.techin.demo.models.Review;
import lt.techin.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


//    @GetMapping("/reviews")
//    public List<Review> getReviews() {
//        return this.reviewRepository.findAll();
//    }
//
//    @GetMapping("/reviews/{id}")
//    public Review getReview(@PathVariable long id) {
//        return reviewRepository.findById(id).orElseThrow();
//    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> insertReview(@RequestBody Review review) {
        Review savedReview = this.reviewService.saveReview(review);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedReview.getId()).toUri()).body(savedReview);
    }

//    @PutMapping("/reviews/{id}")
//    public Review updateReview(@RequestBody Review review, @PathVariable long id) {
//        if (this.reviewRepository.existsById(id)) {
//            Review reviewFromDb = this.reviewRepository.findById(id).orElseThrow();
//
//            reviewFromDb.setMovie(review.getMovie());
//            reviewFromDb.setReview(review.getReview());
//            reviewFromDb.setUser(review.getUser());
//            reviewFromDb.setRating(review.getRating());
//            reviewFromDb.setReviewDate(review.getReviewDate());
//
//            return this.reviewRepository.save(reviewFromDb);
//        }
//        return this.reviewRepository.save(review);
//    }
//
//    @DeleteMapping("/reviews/{id}")
//    public void deleteReview(@PathVariable long id) {
//        this.reviewRepository.deleteById(id);
//    }
}
