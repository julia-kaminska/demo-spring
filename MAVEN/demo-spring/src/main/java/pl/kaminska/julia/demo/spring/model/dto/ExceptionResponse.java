package pl.kaminska.julia.demo.spring.model.dto;

public class ExceptionResponse {
    private String errorMessage;

    public ExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
