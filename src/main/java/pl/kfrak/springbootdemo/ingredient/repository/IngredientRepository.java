package pl.kfrak.springbootdemo.ingredient.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
