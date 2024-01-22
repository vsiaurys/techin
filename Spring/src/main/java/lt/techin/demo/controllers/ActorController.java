package lt.techin.demo.controllers;

import lt.techin.demo.models.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ActorController {


    private ArrayList<Actor> actors = new ArrayList<>(
            List.of(new Actor(0L, "Tom Hanks", 'M',
                            new Date(1956, 07, 9), (short) 183, (float) 0.0, 0.0, ""),
                    new Actor(1L, "Wallace Shawn", 'M',
                            new Date(1943, 11, 12), (short) 157, (float) 0.0, 0.0, ""),
                    new Actor(2L, "Tim Allen", 'M',
                            new Date(1953, 06, 13), (short) 179, (float) 0.0, 0.0, "")));


    @GetMapping("/actors")
    public ArrayList<Actor> getActors() {
        return this.actors;
    }

    @GetMapping("/actors/{index}")
    public Actor getActor(@PathVariable int index) {
        return this.actors.get(index);
    }
}
