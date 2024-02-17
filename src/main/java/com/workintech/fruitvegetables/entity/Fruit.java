package com.workintech.fruitvegetables.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="fruits", schema="fsweb")
public class Fruit extends Food {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
    private FruitType fruitType;
}
