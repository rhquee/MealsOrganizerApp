package pl.kfrak.springbootdemo.dish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.dish.service.DishServiceImpl;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    DishServiceImpl dishService;

    @GetMapping(value = "/{dishId}")
    public Dish findDishById (@PathVariable Integer dishId){
        return dishService.findDishById(dishId);
    }

    @GetMapping(value = "/all")
    public List<Dish> getDishes() {
        return dishService.findAll();
    }

    @PostMapping(value = "/createDish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish){
        Dish response = dishService.insertDish(dish);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
