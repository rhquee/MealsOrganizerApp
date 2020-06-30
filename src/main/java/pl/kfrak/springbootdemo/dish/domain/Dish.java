package pl.kfrak.springbootdemo.dish.domain;

import pl.kfrak.springbootdemo.dishingredient.Recipe;

import javax.persistence.*;
import java.util.Set;


@Entity(name="dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "dish_description")
    private String dishDescription;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<Recipe> recipe;

    public Dish() {
    }

    public Dish(Integer dishId, String dishName, String dishDescription, String notes, Set<Recipe> recipe) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.notes = notes;
        this.recipe = recipe;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }
}
