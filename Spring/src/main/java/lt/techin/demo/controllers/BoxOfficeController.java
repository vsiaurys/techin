package lt.techin.demo.controllers;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.repositories.BoxOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoxOfficeController {
    private final BoxOfficeRepository boxOfficeRepository;

    @Autowired
    public BoxOfficeController(BoxOfficeRepository boxOfficeRepository) {
        this.boxOfficeRepository = boxOfficeRepository;
    }

    @GetMapping("/boxoffice")
    public List<BoxOffice> getBoxOffices() {
        return this.boxOfficeRepository.findAll();
    }
}
