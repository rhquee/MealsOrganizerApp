package pl.kfrak.springbootdemo.dish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kfrak.springbootdemo.dish.repository.DishRepository;
import pl.kfrak.springbootdemo.dish.domain.Dish;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findDishById(Integer dishId){
        return dishRepository.findDishById(dishId);
    }

    public boolean checkIfDishExists(String dishName){
        if(dishRepository.existsByDishName(dishName)){
            return true;
        }else{
            return false;
        }
    }

    public void insertDishIfNotExists(Dish dish){
        if(checkIfDishExists(dish.getDishName())){
            System.out.println("dish arleady in db");
        }else{
            insertDish(dish);
        }
    }

    public Dish insertDish(Dish dish) {
        dishRepository.saveAndFlush(dish);
        return dish;
    }
}
