package lt.techin.demo.services;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxOfficeService {
    private final BoxOfficeRepository boxOfficeRepository;

    @Autowired
    public BoxOfficeService(BoxOfficeRepository boxOfficeRepository) {
        this.boxOfficeRepository = boxOfficeRepository;
    }

    public List<BoxOffice> findAllBoxOffices() {
        return this.boxOfficeRepository.findAll();
    }
}
