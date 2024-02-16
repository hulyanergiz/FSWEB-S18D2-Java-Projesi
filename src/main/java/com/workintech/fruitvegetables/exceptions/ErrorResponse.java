package com.workintech.fruitvegetables.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime createdAt;
}
