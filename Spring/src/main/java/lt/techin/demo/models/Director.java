package lt.techin.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Directors")
public class Director {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, message = "Name should be at least 2 characters long")
    private String name;
    private float rating;

    public Director(long id, String name, float rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Director() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
