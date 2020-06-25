package pl.kfrak.springbootdemo.dish.service;

import org.springframework.stereotype.Service;
import pl.kfrak.springbootdemo.dish.repository.DishRepository;
import pl.kfrak.springbootdemo.dish.domain.Dish;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishServiceImpl {

    @Resource
    private DishRepository dishRepository;

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findDishById(Integer dishId){
        return dishRepository.findDishById(dishId);
    }

    public Dish insertDish(Dish dish) {
        dishRepository.save(dish);
        return dish;
    }
}
