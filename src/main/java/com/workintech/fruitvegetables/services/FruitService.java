package com.workintech.fruitvegetables.services;

import com.workintech.fruitvegetables.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit save(Fruit fruit);
    Fruit delete(long id);
    Fruit findById(long id);
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);



}
