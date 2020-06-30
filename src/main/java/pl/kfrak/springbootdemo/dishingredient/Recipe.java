package pl.kfrak.springbootdemo.dishingredient;

import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="dish_ingredient")
public class Recipe implements Serializable {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    private Ingredient ingredient;

    private String quantity;

    @Column(name = "measure_type")
    @Enumerated(value = EnumType.STRING)
    private MeasureType measureType;

    public Recipe() {
    }

    public Recipe(Integer id, Dish dish, Ingredient ingredient, String quantity, MeasureType measureType) {
        this.id = id;
        this.dish = dish;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.measureType = measureType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }
}
