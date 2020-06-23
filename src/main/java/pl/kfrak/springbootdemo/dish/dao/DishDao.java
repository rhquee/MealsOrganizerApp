package pl.kfrak.springbootdemo.dish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import java.util.List;
import java.util.Set;

public interface DishDao extends JpaRepository<Dish, Integer> {

    @Query("select d from dish d where d.dishId = :dishId")
    Dish findDishById (@Param("dishId") Integer dishId);

    @Query("select d from dish d")
    List<Dish> findAll();

    @Modifying
    @Query("update dish d set d.ingredients = :ingredient where d.dishId = :dishId")
    void addIngredientToDish(@Param("dishId") Integer dishId, @Param("ingredient") Set<Ingredient> ingredient);


    //void insertDish(Dish dish);
//
//    void updateDish(Dish dish);
//
//    void executeUpdateEmployee(Dish dish);

//    @Query("delete from dish d where d.dishId = :dishId")
//    void deleteDishById(@Param("dishId") Integer dishId);
}
