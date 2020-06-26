package pl.kfrak.springbootdemo.dishingredient;

import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="dish_ingredient")
public class DishIngredient implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String quantity;

    public DishIngredient() {
    }

    public DishIngredient(Dish dish, Ingredient ingredient, String quantity) {
        this.dish = dish;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
