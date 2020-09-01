package pl.kfrak.springbootdemo.assignedRecipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.kfrak.springbootdemo.recipe.Recipe;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assigned_recipe")
public class AssignedRecipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assigned_recipe_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id" /*insertable=false, updatable=false*/)
    //@JsonIgnoreProperties(value = "recipe", allowSetters = true)
    @JsonIgnoreProperties(value = "assigned_recipe", allowSetters = true)
    private Recipe recipeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id", referencedColumnName = "day_id" /*insertable=false, updatable=false*/)
    @JsonIgnoreProperties(value = "assigned_recipe", allowSetters = true)
    private Day dayId;

    private String mealType;
}
