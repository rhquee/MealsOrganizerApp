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

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<Recipe> recipe;

    public Dish() {
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

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

}
