package pl.kfrak.springbootdemo.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;
import pl.kfrak.springbootdemo.ingredient.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping(value = "/{ingredientId}")
    public Ingredient findIngredientById(@PathVariable Integer ingredientId){
        return ingredientService.findIngredientById(ingredientId);
    }

    @GetMapping(value = "/all")
    public List<Ingredient> findAll(){
        return ingredientService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient){
        Ingredient response = ingredientService.insertIngredient(ingredient);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public void addIngredientIfNotExists(@RequestBody Ingredient ingredient){
        ingredientService.insertIngredientIfNotExists(ingredient);
    }

}
