package pl.kfrak.springbootdemo.dish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.dish.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping(value = "/{dishId}")
    public Dish findDishById (@PathVariable Integer dishId){
        return dishService.findDishById(dishId);
    }

    @GetMapping(value = "/all")
    public List<Dish> getDishes() {
        return dishService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish){
        Dish response = dishService.insertDish(dish);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public void addDishIfNotExists(@RequestBody Dish dish){
        dishService.insertDishIfNotExists(dish);
    }
}
