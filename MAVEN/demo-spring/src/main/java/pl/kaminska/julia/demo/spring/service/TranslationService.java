package pl.kaminska.julia.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kaminska.julia.demo.spring.model.dto.Translation;
import pl.kaminska.julia.demo.spring.model.dto.TranslationUpdate;
import pl.kaminska.julia.demo.spring.model.entity.TranslationEntity;
import pl.kaminska.julia.demo.spring.repository.TranslationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TranslationService {

    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public List<Translation> getAllTranslationsFromDataSource() {
        List<TranslationEntity> all = translationRepository.findAll();

        return new ArrayList<>(
                all.stream() //[id, code, language, translation]
                        .map(entity -> new Translation(entity.getCode(), new HashMap<>(Map.of(entity.getLanguage(), entity.getTranslation())))) //[code, map[language, translation]
                        .collect(Collectors.toMap(
                                translation -> translation.getCode(),
                                translation -> translation,
                                (oldVal, newVal) -> {
                                    Map<String, String> newMap = newVal.getTranslations();
                                    oldVal.getTranslations().putAll(newMap);
                                    return oldVal;
                                }
                        )).values());

        //[id, code, language, translation]
        //[code, map[language, translation]
//        new Translation("main.page.welcome-message", Map.of("EN", "Hello"));
//        new Translation("main.page.welcome-message", Map.of("PL", "Witaj"));
//        new Translation("main.page.welcome-message", Map.of("CN", "欢迎"));
//
//        Translation translation = new Translation(
//                "main.page.welcome-message",
//                Map.of("EN", "Hello",
//                        "PL", "Witaj",
//                        "CN", "欢迎")
//        );
//
//        return List.of(translation);
    }
        public List<TranslationEntity> saveTranslation(Translation newTranslation) {
            return translationRepository.saveAll(newTranslation.getTranslations()
                    .entrySet()
                    .stream()
                    .map(x -> {
                        TranslationEntity entity = new TranslationEntity();
                        entity.setCode(newTranslation.getCode());
                        entity.setLanguage(x.getKey());
                        entity.setTranslation(x.getValue());
                        return entity;
                    })
                    .collect(Collectors.toList()));
        }
    public void updateTranslation(String code, String language, TranslationUpdate translationUpdate) {
        translationRepository.findByCodeAndLanguage(code, language)
                .map(x -> {
                    x.setTranslation(translationUpdate.getTranslation());
                    return x;
                })
                .ifPresentOrElse(
                        translationRepository::save,
                        () -> {
                            throw new IllegalArgumentException("nie znaleziono obiektu dla podanych code i language");
                        }
                );

    }

    public void deleteTranslation(String code){
        translationRepository.deleteAll(translationRepository.findAllByCode(code));
    }
    public void deleteTranslation(String code, String language){
        translationRepository.findByCodeAndLanguage(code, language)
                .ifPresent(translationRepository::delete);

//        translationRepository.delete(translationRepository.findByCodeAndLanguage(code, language).get()); //ale get rzuci NPE jak nie ma takiego wpisu
    }

}
