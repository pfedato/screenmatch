package br.com.alura.screenmatch.exception;

public class ExceptionYearConversionError extends RuntimeException {
    private String message;

    public ExceptionYearConversionError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
