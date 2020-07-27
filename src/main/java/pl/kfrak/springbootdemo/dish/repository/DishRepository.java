package pl.kfrak.springbootdemo.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kfrak.springbootdemo.dish.domain.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

   // @Query("select d from dish d where d.dishId = :dishId")
    Dish findDishById (@Param("dishId") Integer dishId);

    //@Query("select d from dish d")
    List<Dish> findAll();

    boolean existsByDishName(@Param("dishName")String dishName);


}
