package lt.techin.demo.services;

import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public Actor findActorById(long id) {
        return actorRepository.findById(id).orElseThrow();
    }

//    public Movie saveMovie(Movie movie) {
//        return this.movieRepository.save(movie);
//    }
//
//    public boolean existsMovieById(long id) {
//        return this.movieRepository.existsById(id);
//    }
//
//    public void deleteMovieById(long id) {
//        this.movieRepository.deleteById(id);
//    }
}
