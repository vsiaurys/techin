package lt.techin.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Directors_movies")
public class DirectorMovie {
    @EmbeddedId
    private DirectorMovieId directorMovieId;

    public DirectorMovieId getDirectorMovieId() {
        return directorMovieId;
    }

    public void setDirectorMovieId(DirectorMovieId directorMovieId) {
        this.directorMovieId = directorMovieId;
    }

}
