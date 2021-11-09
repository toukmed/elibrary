package com.management.elibrary.errorhandlers;

import java.util.List;

public class ResponseError {

    private String message;
    private List<ErrorModel> errors;

    public ResponseError(String message, List<ErrorModel> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
