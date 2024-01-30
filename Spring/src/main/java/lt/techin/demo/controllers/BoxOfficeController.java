package lt.techin.demo.controllers;

import lt.techin.demo.models.BoxOffice;
import lt.techin.demo.services.BoxOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoxOfficeController {
    private final BoxOfficeService boxOfficeService;

    @Autowired
    public BoxOfficeController(BoxOfficeService boxOfficeService) {
        this.boxOfficeService = boxOfficeService;
    }

    @GetMapping("/boxoffices")
    public List<BoxOffice> getBoxOffices() {
        return this.boxOfficeService.findAllBoxOffices();
    }

}
