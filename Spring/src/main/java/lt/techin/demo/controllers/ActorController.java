package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.ActorRepository;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors")
    public List<Actor> getActors() {
        return this.actorRepository.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable long id) {
        return actorRepository.findById(id).orElseThrow();
    }

    @PostMapping("/actors")
    public void insertActor(@RequestBody Actor actor) {
        this.actorRepository.save(actor);
    }

    @PutMapping("/actors/{id}")
    public Actor updateActor(@RequestBody Actor actor, @PathVariable long id) {
        if (this.actorRepository.existsById(id)) {
            Actor actorFromDb = this.actorRepository.findById(id).orElseThrow();

            actorFromDb.setName(actor.getName());
            actorFromDb.setSex(actor.getSex());
            actorFromDb.setDateOfBirth(actor.getDateOfBirth());
            actorFromDb.setHeight(actor.getHeight());
            actorFromDb.setRating(actor.getRating());
            actorFromDb.setSalaryPerDay(actor.getSalaryPerDay());
            actorFromDb.setLinkToPicture(actor.getLinkToPicture());

            return this.actorRepository.save(actorFromDb);
        }
        return this.actorRepository.save(actor);
    }
    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable long id) {
        this.actorRepository.deleteById(id);
    }
}
