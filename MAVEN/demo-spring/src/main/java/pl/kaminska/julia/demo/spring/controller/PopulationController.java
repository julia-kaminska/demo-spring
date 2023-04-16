package pl.kaminska.julia.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kaminska.julia.demo.spring.model.dto.Population;
import pl.kaminska.julia.demo.spring.service.PopulationService;

import java.util.List;
@RestController
public class PopulationController {
    private final PopulationService populationService;

    @Autowired
    PopulationController(PopulationService populationService){
        this.populationService =populationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, path = "/populations")
    public List<Population> getAllPopulations() {
        return populationService.getAllPopulationsFromDataSource();
    }
}
