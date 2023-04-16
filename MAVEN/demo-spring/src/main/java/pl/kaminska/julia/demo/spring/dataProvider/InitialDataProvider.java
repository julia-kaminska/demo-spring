package pl.kaminska.julia.demo.spring.dataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kaminska.julia.demo.spring.model.entity.TranslationEntity;
import pl.kaminska.julia.demo.spring.repository.TranslationRepository;

import java.util.Map;

@Component
public class InitialDataProvider implements CommandLineRunner {

    private final TranslationRepository repository;

    @Value("${data.user.admin.login}")
    private String adminUser;

    private String adminPassword;

    @Autowired
    public InitialDataProvider(TranslationRepository repository,
                               @Value("${data.user.admin.password}") String adminPassword) {
        this.repository = repository;
        System.out.println(adminUser + " : " + adminPassword);
        this.adminPassword = adminPassword;
    }

    @Override
    public void run(String... args) throws Exception {

        createAndSave("main.page.welcome-message", "EN", "Hello");
        createAndSave("main.page.welcome-message", "PL", "Witaj");
        createAndSave("main.page.welcome-message", "CN", "欢迎");
        System.out.println(adminUser + " : " + adminPassword);
    }

    private void createAndSave(String code, String language, String translation) {
        TranslationEntity entity = new TranslationEntity();
        entity.setCode(code);
        entity.setLanguage(language);
        entity.setTranslation(translation);
        repository.save(entity);
    }
}
