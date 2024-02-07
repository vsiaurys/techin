package lt.techin.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, message = "Title should be at least 1 characters long")
    private String title;
    @PastOrPresent(message = "The release date should be present or past only")
    private LocalDate dateReleased;
    @Min(value = 30, message = "The length of movie should be in range between 30 and 600 minutes")
    private short lengthMinutes;

    public Movie(String title, LocalDate dateReleased, short lengthMinutes) {
        this.title = title;
        this.dateReleased = dateReleased;
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

    public LocalDate getDateReleased() {
        return dateReleased;
    }

    public short getLengthMinutes() {
        return lengthMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateReleased(LocalDate dateReleased) {
        this.dateReleased = dateReleased;
    }

    public void setLengthMinutes(short lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}
