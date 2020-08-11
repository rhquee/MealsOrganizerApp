package pl.kfrak.springbootdemo.assignedRecipe;

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
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id", referencedColumnName = "day_id" /*insertable=false, updatable=false*/)
    private Day day;

    private String mealType;
}
