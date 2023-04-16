package pl.kaminska.julia.demo.spring.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kaminska.julia.demo.spring.model.Translation;

import java.util.List;
import java.util.Map;

@RestController
public class TranslationController {
    @RequestMapping(method = RequestMethod.GET, path = "/translations")
    public List<Translation> getAllTranslations() {
        System.out.println("Hello");
        Translation translation = new Translation(
                "main.page.welcome-message",
                Map.of("EN", "Hello", "PL", "Witaj", "CN", "欢迎")
        );

        return List.of(translation);

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
}
