package lt.techin.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;
    private String review;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
    private short rating;
    private Date reviewDate;

    public Review(long id, Movie movie, String review, User user, short rating, Date reviewDate) {
        this.id = id;
        this.movie = movie;
        this.review = review;
        this.user = user;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getReview() {
        return review;
    }

    public User getUser() {
        return user;
    }

    public short getRating() {
        return rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
