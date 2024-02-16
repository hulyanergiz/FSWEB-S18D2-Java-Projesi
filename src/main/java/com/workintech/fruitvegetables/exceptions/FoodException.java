package com.workintech.fruitvegetables.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FoodException extends RuntimeException{
    private HttpStatus httpStatus;

    public FoodException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
