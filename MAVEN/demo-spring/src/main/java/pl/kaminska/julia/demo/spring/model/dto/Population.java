package pl.kaminska.julia.demo.spring.model.dto;

public class Population {

    private String name;
    private int population;
    private int birthrate;
    private int id;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getBirthrate() {
        return birthrate;
    }

    public int getId() {
        return id;
    }

    public Population(String name, int population, int birthrate, int id) {
        this.name = name;
        this.population = population;
        this.birthrate = birthrate;
        this.id = id;
    }
}
