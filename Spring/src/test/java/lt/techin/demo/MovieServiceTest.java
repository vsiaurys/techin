package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = this.movieRepository
                .save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005, (short) 60));
        Movie savedMovie2 = this.movieRepository
                .save(new Movie("HOme Alone", "Stephen Spielberg", (short) 1999, (short) 120));
        List<Movie> movies = this.movieService.findAllMovies();

        assertThat(movies.get(0).getTitle()).isEqualTo(savedMovie1.getTitle());
        assertThat(movies.get(0).getDirector()).isEqualTo(savedMovie1.getDirector());
        assertThat(movies.get(0).getYearReleased()).isEqualTo(savedMovie1.getYearReleased());
        assertThat(movies.get(0).getLengthMinutes()).isEqualTo(savedMovie1.getLengthMinutes());

        assertThat(movies.get(1).getTitle()).isEqualTo(savedMovie2.getTitle());
        assertThat(movies.get(1).getDirector()).isEqualTo(savedMovie2.getDirector());
        assertThat(movies.get(1).getYearReleased()).isEqualTo(savedMovie2.getYearReleased());
        assertThat(movies.get(1).getLengthMinutes()).isEqualTo(savedMovie2.getLengthMinutes());

    }
}
