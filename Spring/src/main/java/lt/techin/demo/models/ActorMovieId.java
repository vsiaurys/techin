package lt.techin.demo.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActorMovieId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Actor_id")
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;

    public ActorMovieId(Actor actor, Movie movie) {
        this.actor = actor;
        this.movie = movie;
    }

    public ActorMovieId() {
    }

    public Actor getActor() {
        return actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ActorMovieId that = (ActorMovieId) o;
        return Objects.equals(actor, that.actor) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, movie);
    }
}
