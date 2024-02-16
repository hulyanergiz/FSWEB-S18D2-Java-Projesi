package com.workintech.fruitvegetables.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name="vegetable",schema="fsweb")
public class Vegetable extends Food {

    @Column(name="is_grown_on_tree")
    private Boolean isGrownOnTree;
}
