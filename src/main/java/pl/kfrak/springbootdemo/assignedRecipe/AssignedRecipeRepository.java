package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssignedRecipeRepository extends JpaRepository<AssignedRecipe, Integer> {

    //@Query(("select ar from assigned_recipe ar where ar.dayId = :dayId"))
   // AssignedRecipe findRecipesForGivenDay(@Param("dayId")Integer dayId);

    AssignedRecipe findAssignedRecipeByDay(@Param("dayId")Integer dayId);

}
