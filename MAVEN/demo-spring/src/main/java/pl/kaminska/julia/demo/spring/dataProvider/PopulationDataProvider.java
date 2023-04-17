package pl.kaminska.julia.demo.spring.dataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("init-data")
public class PopulationDataProvider implements CommandLineRunner {
    @Value("${data.user.first-object.kraj}")
    private String kraj;

    @Value("${data.user.first-object.liczebnosc}")
    private long liczebnosc;

    @Value("${data.user.first-object.przyrost}")
    private double przyrost;

    private PopulationRepository populationRepository;
    private PopulationDefaultObjectProperties defaultObjectProperties;

    @Autowired
    public PopulationDataProvider(
            PopulationRepository populationRepository,
            PopulationDefaultObjectProperties defaultObjectProperties) {
        this.populationRepository = populationRepository;
        this.defaultObjectProperties = defaultObjectProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(kraj);
        System.out.println(liczebnosc);
        System.out.println(przyrost);
        PopulationEntity populationEntity = new PopulationEntity();
        populationEntity.setKraj(kraj);
        populationEntity.setLiczebnosc(liczebnosc);
        populationEntity.setPrzyrost(przyrost);
        //TODO: wypelniamy na podstawie danych z application.properties
        PopulationEntity populationEntity2 = new PopulationEntity();
        populationEntity2.setKraj(defaultObjectProperties.getKraj());
        populationEntity2.setLiczebnosc(defaultObjectProperties.getLiczebnosc());
        populationEntity2.setPrzyrost(defaultObjectProperties.getPrzyrost());
        populationRepository.saveAll(List.of(populationEntity, populationEntity2));
    }

}
