package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = this.movieRepository.save(new Movie("Madagascar", LocalDate.of(1976, 5, 3), (short) 60));
        Movie savedMovie2 = this.movieRepository.save(new Movie("Home Alone", LocalDate.of(2000, 11, 19), (short) 120));
        List<Movie> movies = this.movieService.findAllMovies();
        then(movies).containsExactly(savedMovie1, savedMovie2);
    }

    @Test
    void findMovieById_saveMovieById_returned() {
        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar", LocalDate.of(2000, 11, 19), (short) 60));
        long id = savedMovie.getId();

        Movie foundMovie = this.movieService.findMovieById(id);

        then(foundMovie).isEqualTo(savedMovie);
    }

//   @Test
//    void findMovieById_findNotExistent_throwError() {
//        Throwable throwable = catchThrowable(
//                () -> this.movieService.findMovieById(1));
//
//        then(throwable).isInstanceOf(NoSuchElementException.class);
//    }

    @Test
    void findMovieById_findNotExistent_returnNull() {
        Movie foundMovie = this.movieRepository.findById(anyLong()).orElse(null);

        then(foundMovie).isEqualTo(null);
    }

    @Test
    void saveMovie_saveNewMovie_returnSavedMovie() {
        Movie savedMovie = this.movieService.saveMovie(new Movie("HOme Alone", LocalDate.of(2000, 11, 19), (short) 120));

        Movie foundMovie = this.movieRepository.findById(savedMovie.getId()).orElse(null);

        then(foundMovie).isEqualTo(savedMovie);
    }

    @Test
    void existsMovieById_checkIfExists_returnTrue() {
        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar", LocalDate.of(2000, 11, 19), (short) 60));

        boolean existsMovie = this.movieService.existsMovieById(savedMovie.getId());

        then(existsMovie).isTrue();
    }

    @Test
    void deleteMovieById_checkIfDeletes_returnFalse() {
        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar", LocalDate.of(2000, 11, 19), (short) 60));

        this.movieService.deleteMovieById(savedMovie.getId());

        then(this.movieRepository.existsById(savedMovie.getId())).isFalse();
    }
}
