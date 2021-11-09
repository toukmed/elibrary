package com.management.elibrary.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandlerController{

    public static final String FAILED_VALIDATION_FOR_INPUT_FIELDS = "Failed validation for input fields";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleMethodArgumentNotValid(ConstraintViolationException ex){

        List<ErrorModel> errorModels = new ArrayList<>();
        errorModels = ex.getConstraintViolations()
                .stream()
                .map(fieldError -> new ErrorModel(fieldError.getPropertyPath().toString(), fieldError.getMessageTemplate()))
                .distinct()
                .collect(Collectors.toList());

        ResponseError errors = new ResponseError(FAILED_VALIDATION_FOR_INPUT_FIELDS, errorModels);

        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleSourceNotFound(IllegalArgumentException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
