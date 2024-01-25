package lt.techin.demo.controllers;

import lt.techin.demo.models.Movie;

import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.movieService.findAllMovies();
    }
//
//    @GetMapping("/movies/{id}")
//    public Movie getMovie(@PathVariable long id) {
//        return movieRepository.findById(id).orElseThrow();
//    }
//
//    @PostMapping("/movies")
//    public Movie insertMovie(@RequestBody Movie movie) {
//        return this.movieRepository.save(movie);
//    }
//
//    @PutMapping("/movies/{id}")
//    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
//        if (this.movieRepository.existsById(id)) {
//            Movie movieFromDb = this.movieRepository.findById(id).orElseThrow();
//
//            movieFromDb.setTitle(movie.getTitle());
//            movieFromDb.setDirector(movie.getDirector());
//            movieFromDb.setYearReleased(movie.getYearReleased());
//            movieFromDb.setLengthMinutes(movie.getLengthMinutes());
//
//            return this.movieRepository.save(movieFromDb);
//        }
//        return this.movieRepository.save(movie);
//    }
//
//    @DeleteMapping("/movies/{id}")
//    public void deleteMovie(@PathVariable long id) {
//        this.movieRepository.deleteById(id);
//    }
}

