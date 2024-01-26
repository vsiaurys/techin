package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
import lt.techin.demo.services.ActorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
public class ActorServiceTest {
    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorRepository actorRepository;

    @Test
    void findAllActors_saveActors_returned() {
        Actor savedActor1 = this.actorRepository
                .save(new Actor("Name 1", 'M', new Date(1950 - 01 - 01),
                        (short) 180, (float) 8.2, 100000, "Link to picture 1"));
        Actor savedActor2 = this.actorRepository
                .save(new Actor("Name 2", 'W', new Date(1965 - 05 - 03),
                        (short) 170, (float) 7.9, 50000, "Link to picture 2"));
        List<Actor> actors = this.actorService.findAllActors();
        then(actors).containsExactly(savedActor1, savedActor2);
    }

//    @Test
//    void findMovieById_saveMovieById_returned() {
//        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar",
//                "Stephen Spielberg", (short) 2005, (short) 60));
//        long id = savedMovie.getId();
//
//        Movie foundMovie = this.movieService.findMovieById(id);
//
//        then(foundMovie).isEqualTo(savedMovie);
//    }
//
//    @Test
//    void findMovieById_findNotExistent_throwError() {
//        Throwable throwable = catchThrowable(
//                () -> this.movieService.findMovieById(1));
//
//        then(throwable).isInstanceOf(NoSuchElementException.class);
//    }
//
//    @Test
//    void saveMovie_saveNewMovie_returnSavedMovie() {
//        Movie savedMovie = this.movieService.saveMovie(new Movie("HOme Alone",
//                "Stephen Spielberg", (short) 1999, (short) 120));
//
//        Movie foundMovie = this.movieRepository.findById(savedMovie.getId()).orElse(null);
//
//        then(foundMovie).isEqualTo(savedMovie);
//    }
//
//    @Test
//    void existsMovieById_checkIfExists_returnTrue() {
//        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar",
//                "Stephen Spielberg", (short) 2005, (short) 60));
//
//        boolean existsMovie = this.movieService.existsMovieById(savedMovie.getId());
//
//        then(existsMovie).isTrue();
//    }
//
//    @Test
//    void deleteMovieById_checkIfDeletes_returnFalse() {
//        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar",
//                "Stephen Spielberg", (short) 2005, (short) 60));
//
//        this.movieService.deleteMovieById(savedMovie.getId());
//
//        then(this.movieRepository.existsById(savedMovie.getId())).isFalse();
//    }
}
