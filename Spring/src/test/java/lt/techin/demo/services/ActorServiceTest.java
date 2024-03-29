package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
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
                .save(new Actor("Name 1", 'M', LocalDate.of(1950, 1, 1),
                        (short) 180, (float) 8.2, 100000, "Link to picture 1"));
        Actor savedActor2 = this.actorRepository
                .save(new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                        (short) 170, (float) 7.9, 50000, "Link to picture 2"));
        List<Actor> actors = this.actorService.findAllActors();
        then(actors).containsExactly(savedActor1, savedActor2);
    }

    @Test
    void findActorById_saveActorById_returned() {
        Actor savedActor = this.actorRepository
                .save(new Actor("Name 1", 'M', LocalDate.of(1950, 1, 1),
                        (short) 180, (float) 8.2, 100000, "Link to picture 1"));

        Actor foundActor = this.actorService.findActorById(savedActor.getId());

        then(foundActor).isEqualTo(savedActor);
    }

    @Test
    void findMovieById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(
                () -> this.actorService.findActorById(1));

        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveActor_saveNewActor_returnSavedActor() {
        Actor savedActor = this.actorRepository
                .save(new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                        (short) 170, (float) 7.9, 50000, "Link to picture 2"));

        Actor foundActor = this.actorRepository.findById(savedActor.getId()).orElse(null);

        then(foundActor).isEqualTo(savedActor);
    }

    @Test
    void existsActorById_checkIfExists_returnTrue() {
        Actor savedActor = this.actorRepository
                .save(new Actor("Name 1", 'M', LocalDate.of(1950, 1, 1),
                        (short) 180, (float) 8.2, 100000, "Link to picture 1"));

        boolean existsActor = this.actorService.existsActorById(savedActor.getId());

        then(existsActor).isTrue();
    }

    @Test
    void deleteActorById_checkIfDeletes_returnFalse() {
        Actor savedActor = this.actorRepository
                .save(new Actor("Name 2", 'W', LocalDate.of(1965, 5, 3),
                        (short) 170, (float) 7.9, 50000, "Link to picture 2"));

        this.actorService.deleteActorById(savedActor.getId());

        then(this.actorRepository.existsById(savedActor.getId())).isFalse();
    }
}
