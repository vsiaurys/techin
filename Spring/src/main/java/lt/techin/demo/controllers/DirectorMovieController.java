package lt.techin.demo.controllers;

import lt.techin.demo.models.Director;
import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.DirectorService;
import lt.techin.demo.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorMovieController {
    private final DirectorMovieRepository directorMovieRepository;
    private final DirectorService directorService;
    private final MovieService movieService;

    public DirectorMovieController(DirectorMovieRepository directorMovieRepository, DirectorService directorService, MovieService movieService) {
        this.directorMovieRepository = directorMovieRepository;
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @GetMapping("/directorsmovies")
    public List<DirectorMovie> getDirectorsMovies() {
        return this.directorMovieRepository.findAll();
    }

    @GetMapping("/directors/{directorId}/movies/{movieId}")
    public DirectorMovie getDirectorMovie(@PathVariable("directorId") long directorId, @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        return this.directorMovieRepository.findById(directorMovieId).orElse(null);
    }

    @PostMapping("/directorsmovies")
    public DirectorMovie saveActorMovie(@RequestBody DirectorMovie directorMovie) {
        return this.directorMovieRepository.save(directorMovie);
    }
}
