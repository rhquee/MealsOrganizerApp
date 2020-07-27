package pl.kfrak.springbootdemo.ingredient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;
import pl.kfrak.springbootdemo.ingredient.repository.IngredientRepository;

import java.util.List;

@Service
@Transactional
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient findIngredientById(Integer ingredientId){
        return ingredientRepository.findIngredientById(ingredientId);
    }

    public boolean checkIfIngredientExists(String ingredientName){
        if(ingredientRepository.existsByName(ingredientName)){
            return true;
        }else{
            return false;
        }
    }

    public void insertIngredientIfNotExists(Ingredient ingredient){
        if(checkIfIngredientExists(ingredient.getName())){
            System.out.println("arleadi in db");
        }else{
            insertIngredient(ingredient);
        }
    }

    public Ingredient insertIngredient(Ingredient ingredient){
        ingredientRepository.saveAndFlush(ingredient);
        return ingredient;
    }

}
