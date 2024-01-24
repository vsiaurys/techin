package lt.techin.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long movieId;
    private String review;
    private String author;
    private short rating;
    private Date reviewDate;

    public Review(long id, long movieId, String review, String author, short rating, Date reviewDate) {
        this.id = id;
        this.movieId = movieId;
        this.review = review;
        this.author = author;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public Review() {
    }
}
