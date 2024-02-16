package com.workintech.fruitvegetables.services;

import com.workintech.fruitvegetables.dao.FruitDao;
import com.workintech.fruitvegetables.entity.Fruit;
import com.workintech.fruitvegetables.exceptions.FoodException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService{

    private FruitDao fruitDao;

    @Override
    public Fruit save(Fruit fruit) {
        return fruitDao.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit deletedFruit=findById(id);
        fruitDao.delete(deletedFruit);
        return deletedFruit;
    }

    @Override
    public Fruit findById(long id) {
        Optional<Fruit> fruitOptional=fruitDao.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new FoodException("Fruit is not found with id :"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitDao.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitDao.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitDao.searchByParameter(name);
    }
}
