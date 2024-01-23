package lt.techin.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    private long id;
    private String title;
    private String director;
    private short yearReleased;
    private short lengthMinutes;

    @Entity
    @Table(name = "Movies")
    public Movie(long id, String title, String director, short yearReleased, short lengthMinutes) {
        this.id = id;
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
}
