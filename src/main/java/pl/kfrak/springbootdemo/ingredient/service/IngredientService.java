package pl.kfrak.springbootdemo.ingredient.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kfrak.springbootdemo.ingredient.dao.IngredientDao;

@Service
@Transactional
public class IngredientService {

    private IngredientDao ingredientDao;

}
