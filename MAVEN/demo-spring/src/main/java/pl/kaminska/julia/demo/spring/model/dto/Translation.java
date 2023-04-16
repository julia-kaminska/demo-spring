package pl.kaminska.julia.demo.spring.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class Translation {

    public Translation(String code, Map<String, String> translations) {
        this.code = code;
        this.translations = translations;
    }
@NotEmpty
    private String code;
    @NotNull
    private Map<String, String> translations;

    public String getCode() {
        return code;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }
}
