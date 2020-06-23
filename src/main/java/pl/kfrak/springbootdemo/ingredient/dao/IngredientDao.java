package pl.kfrak.springbootdemo.ingredient.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

public interface IngredientDao extends CrudRepository<Ingredient, Integer> {
}
