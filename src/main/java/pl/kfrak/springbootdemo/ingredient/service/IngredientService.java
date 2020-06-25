package pl.kfrak.springbootdemo.ingredient.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kfrak.springbootdemo.ingredient.repository.IngredientRepository;

@Service
@Transactional
public class IngredientService {

    private IngredientRepository ingredientRepository;

}
