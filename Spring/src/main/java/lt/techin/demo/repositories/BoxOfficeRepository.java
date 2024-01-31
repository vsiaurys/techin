package lt.techin.demo.repositories;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxOfficeRepository extends JpaRepository<BoxOffice, Movie> {
}
