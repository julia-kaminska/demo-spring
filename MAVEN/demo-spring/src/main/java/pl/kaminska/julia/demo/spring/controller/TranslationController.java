package pl.kaminska.julia.demo.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kaminska.julia.demo.spring.model.dto.Translation;
import pl.kaminska.julia.demo.spring.service.TranslationService;

import java.util.List;

@RestController
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, path = "/translations")
    public List<Translation> getAllTranslations() {
        return translationService.getAllTranslationsFromDataSource();
    }

        //    @RequestMapping(method = RequestMethod.POST, path = "/translations")
//    public void saveNewTranslation(){
//        System.out.println("Hello");
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, path = "/translations")
//    public void updateTranslation(){
//        System.out.println("Hello");
//    }


    }

