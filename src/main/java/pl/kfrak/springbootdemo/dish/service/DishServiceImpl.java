package pl.kfrak.springbootdemo.dish.service;

import org.springframework.stereotype.Service;
import pl.kfrak.springbootdemo.dish.dao.DishDao;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DishServiceImpl {
    @Resource
    private  /*final*/ DishDao dishDao;

    public Dish findDishById(Integer dishId){
        return dishDao.findDishById(dishId);
    }

    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    public Dish insertDish(Dish dish) {
        dishDao.save(dish);
        return dish;
    }

    public void addIngredientToDish(Integer dishId, Set<Ingredient> ingredient){
        dishDao.addIngredientToDish(dishId, ingredient);
    }


//    public void updateDish(Dish dish) {
//        dishDao.updateDish(dish);
//
//    }
//    public void executeUpdateDish(Dish dish) {
//        dishDao.executeUpdateEmployee(dish);
//
//    }

    public void deleteDishById(Dish dish) {
        dishDao.delete(dish);

    }

    public void addIngredientToDish(Ingredient ingredient){

    }
}
