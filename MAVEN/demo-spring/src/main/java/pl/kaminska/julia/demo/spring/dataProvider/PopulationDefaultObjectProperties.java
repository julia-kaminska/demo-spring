package pl.kaminska.julia.demo.spring.dataProvider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "data.user.second-object")
public class PopulationDefaultObjectProperties {
    private String kraj;
    private long liczebnosc;
    private double przyrost;

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public long getLiczebnosc() {
        return liczebnosc;
    }

    public void setLiczebnosc(long liczebnosc) {
        this.liczebnosc = liczebnosc;
    }

    public double getPrzyrost() {
        return przyrost;
    }

    public void setPrzyrost(double przyrost) {
        this.przyrost = przyrost;
    }
}
