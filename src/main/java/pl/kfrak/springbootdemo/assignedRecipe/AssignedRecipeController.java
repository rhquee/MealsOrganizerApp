package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kfrak.springbootdemo.recipe.Recipe;

@RestController
@RequestMapping("/ar")
public class AssignedRecipeController {

    @Autowired
    AssignedRecipeService assignedRecipeService;

    @PostMapping(value = "/add")
    public ResponseEntity<AssignedRecipe> addRecipeToDay(@RequestBody AssignedRecipe assignedRecipe){
        AssignedRecipe response = assignedRecipeService.addRecipeToDay(assignedRecipe);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{dayId}")
        public AssignedRecipe findRecipesForGivenDay (@PathVariable Integer dayId){
            return assignedRecipeService.findRecipesForGivenDay(dayId);
        }
    }
