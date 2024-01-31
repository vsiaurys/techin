package lt.techin.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, message = "Title should be at least 1 characters long")
    private String title;
    @NotNull
    @Size(min = 1, message = "Director should be at least 1 characters long")
    private String director;
    @NotNull
    @Size(min = 1900, message = "The release year should be at least 1900")
    private short yearReleased;
    @Size(min = 30, message = "The length of movie should be at least 30 minutes")
    private short lengthMinutes;

    public Movie(String title, String director, short yearReleased, short lengthMinutes) {
        this.title = title;
        this.director = director;
        this.yearReleased = yearReleased;
        this.lengthMinutes = lengthMinutes;
    }

    public Movie() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public short getYearReleased() {
        return yearReleased;
    }

    public short getLengthMinutes() {
        return lengthMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearReleased(short yearReleased) {
        this.yearReleased = yearReleased;
    }

    public void setLengthMinutes(short lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}
