package pl.kfrak.springbootdemo.ingredient.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;
import pl.kfrak.springbootdemo.ingredient.repository.IngredientRepository;

import java.util.List;

@Service
@Transactional
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient findDishById(Integer ingredientId){
        return ingredientRepository.findIngredientById(ingredientId);
    }

    public Ingredient insertIngredient(Ingredient ingredient){
        ingredientRepository.saveAndFlush(ingredient);
        return ingredient;
    }

}
