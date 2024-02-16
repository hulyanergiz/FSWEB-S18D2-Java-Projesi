package com.workintech.fruitvegetables.dao;

import com.workintech.fruitvegetables.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableDao extends JpaRepository<Vegetable,Long> {

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> getByPriceDesc();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price")
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:parameter%")
    List<Vegetable> searchByParameter(String parameter);


}
