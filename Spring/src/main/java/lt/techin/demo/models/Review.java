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

    public long getId() {
        return id;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    public short getRating() {
        return rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
