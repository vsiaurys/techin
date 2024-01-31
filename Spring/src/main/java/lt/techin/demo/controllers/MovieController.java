package lt.techin.demo.controllers;

import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return movieService.findMovieById(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> insertMovie(@RequestBody Movie movie) {
        Movie savedMovie = this.movieService.saveMovie(movie);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedMovie.getId()).toUri()).body(savedMovie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        if (this.movieService.existsMovieById(id)) {
            Movie movieFromDb = this.movieService.findMovieById(id);

            movieFromDb.setTitle(movie.getTitle());
            movieFromDb.setDirector(movie.getDirector());
            movieFromDb.setYearReleased(movie.getYearReleased());
            movieFromDb.setLengthMinutes(movie.getLengthMinutes());

            return ResponseEntity.ok(this.movieService.saveMovie(movieFromDb));
        }
        Movie savedMovie = this.movieService.saveMovie(movie);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedMovie.getId()).toUri()).body(savedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {

        if (this.movieService.existsMovieById(id)) {
            this.movieService.deleteMovieById(id);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
