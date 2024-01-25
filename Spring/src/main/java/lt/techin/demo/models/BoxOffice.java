package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Boxoffice")
public class BoxOffice {
    @Id
    @OneToOne
    @JoinColumn(name="Movie_id")
    private Movie movie;
    private float rating;
    private long domesticSales;
    private long internationalSales;

    public BoxOffice(Movie movie, float rating, long domesticSales, long internationalSales) {
        this.movie = movie;
        this.rating = rating;
        this.domesticSales = domesticSales;
        this.internationalSales = internationalSales;
    }

    public BoxOffice() {
    }
}
