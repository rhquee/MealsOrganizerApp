package pl.kfrak.springbootdemo.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    Ingredient findIngredientById (@Param("ingredientId") Integer ingredientId);
    boolean existsByName(@Param("ingredientName") String ingredientName);
    List<Ingredient> findAll();
}
