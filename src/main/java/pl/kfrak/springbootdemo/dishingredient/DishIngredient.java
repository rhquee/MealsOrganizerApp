package pl.kfrak.springbootdemo.dishingredient;

import com.google.common.base.Objects;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "dish_ingredient")
public class DishIngredient implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Dish dish;

    @Id
    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    private String quantity;

    public DishIngredient() {
    }

    public DishIngredient(Ingredient ingredient, String quantity) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishIngredient)) return false;
        DishIngredient that = (DishIngredient) o;
        return Objects.equal(dish, that.dish) &&
                Objects.equal(ingredient, that.ingredient) &&
                Objects.equal(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dish, ingredient, quantity);
    }
}
