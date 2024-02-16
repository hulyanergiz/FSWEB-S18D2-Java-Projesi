package com.workintech.fruitvegetables.services;

import com.workintech.fruitvegetables.dao.VegetableDao;
import com.workintech.fruitvegetables.entity.Vegetable;
import com.workintech.fruitvegetables.exceptions.FoodException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableDao vegetableDao;


    @Override
    public Vegetable save(Vegetable vegetable) {

        return vegetableDao.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {

        Vegetable deletedVegetable=findById(id);
        vegetableDao.delete(deletedVegetable);
        return deletedVegetable;
    }

    @Override
    public Vegetable findById(long id) {

        Optional<Vegetable> vegetableOptional=vegetableDao.findById(id);
        return vegetableOptional.orElseThrow(()->new FoodException("Vegetable is not found with id: "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Vegetable> getByPriceDesc() {

        return vegetableDao.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {

        return vegetableDao.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {

        return vegetableDao.searchByParameter(name);
    }
}

