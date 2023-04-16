package pl.kaminska.julia.demo.spring.service;

import org.springframework.stereotype.Service;
import pl.kaminska.julia.demo.spring.model.dto.Population;

import java.util.List;
@Service
public class PopulationService {

    public List<Population> getAllPopulationsFromDataSource() {
        Population population = new Population(
                "Argentina", 3, 91, 1
        );
        Population population2 = new Population("Oman", 8, 85, 2
        );
        return List.of(population, population2);
    }
}
