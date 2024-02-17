package com.workintech.fruitvegetables.controller;

import com.workintech.fruitvegetables.entity.Vegetable;
import com.workintech.fruitvegetables.services.VegetableService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public Vegetable findById(@Validated @PathVariable Long id){
        return vegetableService.findById(id);
    }
    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }
    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@Validated String name){
        return vegetableService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }

}
