package lt.techin.demo.services;

import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import lt.techin.demo.repositories.DirectorMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorMovieService {
    private final DirectorMovieRepository directorMovieRepository;

    @Autowired
    public DirectorMovieService(DirectorMovieRepository directorMovieRepository) {
        this.directorMovieRepository = directorMovieRepository;
    }

    public List<DirectorMovie> findAllDirectorsMovies() {
        return directorMovieRepository.findAll();
    }

    public DirectorMovie findDirectorMovieById(DirectorMovieId directorMovieId) {
        return directorMovieRepository.findById(directorMovieId).orElseThrow();
    }

    public DirectorMovie saveDirectorMovie(DirectorMovie directorMovie) {
        return this.directorMovieRepository.save(directorMovie);
    }
//
//    public boolean existsMovieById(long id) {
//        return this.movieRepository.existsById(id);
//    }
//
//    public void deleteMovieById(long id) {
//        this.movieRepository.deleteById(id);
//    }

}
