package lt.techin.demo.repositories;

import lt.techin.demo.models.ActorMovie;
import lt.techin.demo.models.ActorMovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, ActorMovieId> {
}
