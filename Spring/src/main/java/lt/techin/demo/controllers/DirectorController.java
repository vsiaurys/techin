package lt.techin.demo.controllers;


import lt.techin.demo.models.Director;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public List<Director> getDirectors() {
        return this.directorService.findAllDirectors();
    }

    @GetMapping("/directors/{id}")
    public Director getDirector(@PathVariable long id) {
        return directorService.findDirectorById(id);
    }

    @PostMapping("/directors")
    public Director insertDirector(@RequestBody Director director) {
        return this.directorService.saveDirector(director);
    }

    @PutMapping("/directors/{id}")
    public Director updateDirector(@RequestBody Director director, @PathVariable long id) {
        if (this.directorService.existsDirectorById(id)) {
            Director directorFromDb = this.directorService.findDirectorById(id);

            directorFromDb.setName(director.getName());
            directorFromDb.setRating(director.getRating());

            return this.directorService.saveDirector(directorFromDb);
        }
        return this.directorService.saveDirector(director);
    }

    @DeleteMapping("/directors/{id}")
    public void deleteDirector(@PathVariable long id) {
        this.directorService.deleteDirectorById(id);
    }
}


