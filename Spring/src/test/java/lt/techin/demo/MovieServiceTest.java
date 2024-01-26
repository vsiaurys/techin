package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.services.MovieService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

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
        Movie savedMovie1 = this.movieRepository.save(new Movie("Madagascar",
                "Stephen Spielberg", (short) 2005, (short) 60));
        Movie savedMovie2 = this.movieRepository.save(new Movie("Home Alone",
                "Stephen Spielberg", (short) 1999, (short) 120));
        List<Movie> movies = this.movieService.findAllMovies();
        then(movies).containsExactly(savedMovie1, savedMovie2);
    }

    @Test
    void findMovieById_saveMovieById_returned() {
        Movie savedMovie = this.movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005, (short) 60));
        long id = savedMovie.getId();

        Movie foundMovie = this.movieService.findMovieById(id);

        then(foundMovie).isEqualTo(savedMovie);
    }

    @Test
    void findMovieById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(() -> this.movieService.findMovieById(1));

        then(throwable).isInstanceOf(NoSuchFieldException.class);
    }

    @Test
    void saveMovie_saveNewMovie_returnSavedMovie() {
        Movie savedMovie = this.movieService.saveMovie(new Movie("HOme Alone",
                "Stephen Spielberg", (short) 1999, (short) 120));

        Movie foundMovie = this.movieRepository.findById(savedMovie.getId()).orElse(null);

        then(foundMovie).isEqualTo(savedMovie);
    }
}
