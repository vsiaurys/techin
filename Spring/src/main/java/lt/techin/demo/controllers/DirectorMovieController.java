package lt.techin.demo.controllers;

import lt.techin.demo.models.Director;
import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.DirectorMovieService;
import lt.techin.demo.services.DirectorService;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class DirectorMovieController {
    private final DirectorMovieService directorMovieService;
    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public DirectorMovieController(DirectorMovieService directorMovieService, DirectorService directorService, MovieService movieService) {
        this.directorMovieService = directorMovieService;
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @GetMapping("/directorsmovies")
    public List<DirectorMovie> getDirectorsMovies() {
        return this.directorMovieService.findAllDirectorsMovies();
    }

    @GetMapping("/directors/{directorId}/movies/{movieId}")
    public DirectorMovie getDirectorMovie(@PathVariable("directorId") long directorId, @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        return this.directorMovieService.findDirectorMovieById(directorMovieId);
    }

    @PostMapping("/directorsmovies")
    public DirectorMovie insertDirectorMovie(@RequestBody DirectorMovie directorMovie) {
        return this.directorMovieService.saveDirectorMovie(directorMovie);

    }


    @PutMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<DirectorMovie> updateDirectorMovie(@RequestBody DirectorMovie directorMovie, @PathVariable("directorId") long directorId, @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        if (this.directorMovieService.existsDirectorMovieById(directorMovieId)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieId);

            return ResponseEntity.ok(this.directorMovieService.saveDirectorMovie(directorMovie));
        }

        DirectorMovie savedDirectorMovie = this.directorMovieService.saveDirectorMovie(directorMovie);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("directors/{directorId}/movies/{movieId}")
                        .buildAndExpand(savedDirectorMovie.getDirectorMovieId().getDirector().getId(), savedDirectorMovie.getDirectorMovieId().getMovie().getId())
                        .toUri())
                .body(savedDirectorMovie);
    }

    @DeleteMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<Void> deleteDirectorMovie(@PathVariable("directorId") long directorId,
                                                    @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        if (this.directorMovieService.existsDirectorMovieById(directorMovieId)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieId);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

