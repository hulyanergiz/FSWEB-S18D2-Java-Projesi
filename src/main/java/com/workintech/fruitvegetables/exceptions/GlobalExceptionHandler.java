package com.workintech.fruitvegetables.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(FoodException foodException){
        ErrorResponse response=new ErrorResponse(foodException.getHttpStatus().value(), foodException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response,foodException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        List errorList=exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String,String>
                        errorMap=new HashMap<>();
                        errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
                        return errorMap;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse response=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

