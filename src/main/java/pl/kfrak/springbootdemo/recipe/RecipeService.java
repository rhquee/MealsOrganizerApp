package pl.kfrak.springbootdemo.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    Recipe findRecipeById(Integer recipeId){
        return recipeRepository.findRecipeById(recipeId);
    }

    List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    Recipe insertRecipe(Recipe recipe){
        recipeRepository.saveAndFlush(recipe);
        return recipe;
    }

    Recipe addIngredientsToRecipe(Recipe recipe){
        recipeRepository.saveAndFlush(recipe);
        return recipe;
    }

}
