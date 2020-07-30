package pl.kfrak.springbootdemo.dish_ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Recipe findRecipeById(Integer recipeId);

    List<Recipe> findAll();

    //Recipe addIngredientsToRecipe();

}
