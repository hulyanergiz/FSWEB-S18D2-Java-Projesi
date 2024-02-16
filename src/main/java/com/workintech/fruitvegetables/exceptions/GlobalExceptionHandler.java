package com.workintech.fruitvegetables.exceptions;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(FoodException foodException){
        log.error("Food Exception: ",foodException.getMessage());
        ErrorResponse response=new ErrorResponse(foodException.getHttpStatus().value(), foodException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response,foodException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        log.error("Exception: ",exception.getMessage());
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
        log.error("Exception: ",exception.getMessage());
        ErrorResponse response=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

