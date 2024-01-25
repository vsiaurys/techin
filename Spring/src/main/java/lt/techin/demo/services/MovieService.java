package lt.techin.demo.services;

import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies () {
        return movieRepository.findAll();
    }

    public Movie findMovieById (long id) {
        return movieRepository.findById(id).orElseThrow();
    }
    public Movie saveMovie (Movie movie) {
        return this.movieRepository.save(movie);
    }

    public boolean existsMovieById(long id){
        return this.movieRepository.existsById(id);
    }


}
