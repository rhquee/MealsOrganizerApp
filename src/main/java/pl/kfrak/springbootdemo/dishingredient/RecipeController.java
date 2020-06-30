package pl.kfrak.springbootdemo.dishingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/{recipeId}")
    public Recipe findRecipeById (@PathVariable Integer recipeId){
        return recipeService.findRecipeById(recipeId);
    }

    @GetMapping(value = "/all")
    public List<Recipe> getRecipes() {
        return recipeService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
//        Recipe response = recipeService.insertRecipe(recipe);
//        return new ResponseEntity<>(response, HttpStatus.OK);
        return ResponseEntity.ok().body(this.recipeService.insertRecipe(recipe));
    }
}
