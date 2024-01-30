package lt.techin.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Actors_movies")
public class ActorMovie {
    @EmbeddedId
    private ActorMovieId actorMovieId;
    private String role;

    public ActorMovieId getActorMovieId() {
        return actorMovieId;
    }

    public void setActorMovieId(ActorMovieId actorMovieId) {
        this.actorMovieId = actorMovieId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


}
