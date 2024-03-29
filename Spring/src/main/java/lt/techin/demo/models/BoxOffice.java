package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Boxoffice")
public class BoxOffice {
    @Id
    private long id;
    @OneToOne
    @JoinColumn(name = "Movie_id")
    @MapsId
    private Movie movie;
    private float rating;
    private long domesticSales;
    private long internationalSales;

    public BoxOffice(long id, Movie movie, float rating, long domesticSales, long internationalSales) {
        this.id = id;
        this.movie = movie;
        this.rating = rating;
        this.domesticSales = domesticSales;
        this.internationalSales = internationalSales;
    }

    public BoxOffice() {
    }

    public long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public float getRating() {
        return rating;
    }

    public long getDomesticSales() {
        return domesticSales;
    }

    public long getInternationalSales() {
        return internationalSales;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDomesticSales(long domesticSales) {
        this.domesticSales = domesticSales;
    }

    public void setInternationalSales(long internationalSales) {
        this.internationalSales = internationalSales;
    }
}
