package com.workintech.fruitvegetables.controller;

import com.workintech.fruitvegetables.entity.Fruit;
import com.workintech.fruitvegetables.services.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/fruits")
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public Fruit findById(@Validated @PathVariable Long id){
        return fruitService.findById(id);
    }
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }
    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@Validated @PathVariable String name){
        return fruitService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        return fruitService.delete(id);
    }


}
