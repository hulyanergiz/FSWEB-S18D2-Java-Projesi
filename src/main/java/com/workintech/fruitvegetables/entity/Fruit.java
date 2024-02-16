package com.workintech.fruitvegetables.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name="fruit", schema="fsweb")
public class Fruit extends Food {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
    private FruitType fruitType;
}
