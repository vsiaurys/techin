package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.ActorMovie;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.ActorService;
import lt.techin.demo.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorMovieController {
    private final ActorMovieRepository actorMovieRepository;
    private final ActorService actorService;
    private final MovieService movieService;

    public ActorMovieController(ActorMovieRepository actorMovieRepository, ActorService actorService, MovieService movieService) {
        this.actorMovieRepository = actorMovieRepository;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/actorsmovies")
    public List<ActorMovie> getActorsMovies() {
        return this.actorMovieRepository.findAll();
    }

    @GetMapping("/actors/{actorId}/movies{movieId}")
    public ActorMovie getActorMovie(@PathVariable("actorid") long actorId, @PathVariable("movieId") long movieId {
        Actor actor = this.actorService.findActorById(actorId);
        Movie movie = this.movieService.findMovieById(movieId);

        return this.actorMovieRepository.findById(actorMovieRepository).orElse(null);
    }

    @PostMapping("/actorsmovies")
    public ActorMovie saveActorMovie(@RequestBody ActorMovie actorMovie) {
        return this.actorMovieRepository.save(actorMovie);
    }

}
