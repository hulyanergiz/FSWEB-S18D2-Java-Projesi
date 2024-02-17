package com.workintech.fruitvegetables.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@MappedSuperclass
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name field cannot be blank")
    @Size(min=3, max=45,message="name must contain a number of characters between 3 and 45")
    private String name;

    @DecimalMin(value="1",message = "Price can be at least 1")
    @NotNull(message = "Price cannot be null")
    private Double price;
}
