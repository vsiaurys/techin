package lt.techin.demo.services;

import lt.techin.demo.models.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

    public Director findDirectorById(long id) {
        return directorRepository.findById(id).orElseThrow();
    }

    public Director saveDirector(Director director) {
        return this.directorRepository.save(director);
    }

    public boolean existsDirectorById(long id) {
        return this.directorRepository.existsById(id);
    }

    public void deleteDirectorById(long id) {
        this.directorRepository.deleteById(id);
    }
}
