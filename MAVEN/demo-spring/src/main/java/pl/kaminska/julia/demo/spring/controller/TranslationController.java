package pl.kaminska.julia.demo.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.kaminska.julia.demo.spring.model.dto.Translation;
import pl.kaminska.julia.demo.spring.service.TranslationService;

import java.util.List;

@RestController
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(
            @Qualifier("translationServiceImpl") TranslationService translationService){
        this.translationService = translationService;
    }

    //CRUD - R = READ / GET
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, path = "/translations")
    public List<Translation> getAllTranslations() {
        return translationService.getAllTranslationsFromDataSource();
    }

    //CRUD - C = CREATE / POST
    @RequestMapping(method = RequestMethod.POST, path = "/translations")
    public void createTranslation(@RequestBody Translation newTranslation){
        System.out.println(newTranslation);
        System.out.println(newTranslation.getCode());
        System.out.println(newTranslation.getTranslations());
        //translationService.saveTranslation(newTranslation);
    }

//    public void createTranslation(@RequestBody String newTranslation){
//        System.out.println(newTranslation);
//        translationService.saveTranslation(newTranslation);
//    }


    }

