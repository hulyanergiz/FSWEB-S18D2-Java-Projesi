package com.workintech.fruitvegetables.services;

import com.workintech.fruitvegetables.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    Vegetable save(Vegetable vegetable);
    Vegetable delete(long id);
    Vegetable findById(long id);
    List<Vegetable> getByPriceDesc();
    List<Vegetable> getByPriceAsc();
    List<Vegetable> searchByName(String name);
}
