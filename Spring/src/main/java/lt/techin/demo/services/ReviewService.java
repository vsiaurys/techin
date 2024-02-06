package lt.techin.demo.services;

import lt.techin.demo.models.Review;
import lt.techin.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


//    public List<Movie> findAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    public Movie findMovieById(long id) {
//        return movieRepository.findById(id).orElseThrow();
//    }

    public Review saveReview(Review review) {
        return this.reviewRepository.save(review);
    }

//    public boolean existsMovieById(long id) {
//        return this.movieRepository.existsById(id);
//    }
//
//    public void deleteMovieById(long id) {
//        this.movieRepository.deleteById(id);
//    }
}
