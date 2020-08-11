package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignedRecipeService {

    @Autowired
    AssignedRecipeRepository assignedRecipeRepository;

    AssignedRecipe addRecipeToDay(AssignedRecipe assignedRecipe){
        assignedRecipeRepository.saveAndFlush(assignedRecipe);
        return assignedRecipe;
    }

    List<AssignedRecipe> findAll(){
        return assignedRecipeRepository.findAll();
    }

    AssignedRecipe findRecipesForGivenDay(Integer dayId){
        return assignedRecipeRepository.findAssignedRecipeByDay(dayId);
    }

}
