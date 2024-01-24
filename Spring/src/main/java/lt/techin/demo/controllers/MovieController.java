package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @PostMapping("/movies")
    public void insertMovie(@RequestBody Movie movie) {
        this.movieRepository.save(movie);
    }
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        if (this.movieRepository.existsById(id)) {
            Movie movieFromDb = this.movieRepository.findById(id).orElseThrow();

            movieFromDb.setTitle(movie.getTitle());
            movieFromDb.setDirector(movie.getDirector());
            movieFromDb.setYearReleased(movie.getYearReleased());
            movieFromDb.setLengthMinutes(movie.getLengthMinutes());

            return this.movieRepository.save(movieFromDb);
        }
        return this.movieRepository.save(movie);
    }
}

