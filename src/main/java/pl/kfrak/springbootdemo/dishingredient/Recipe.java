package pl.kfrak.springbootdemo.dishingredient;

import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dish_ingredient")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @ManyToOne(cascade=CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id")
    private Dish dishId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
    private Ingredient ingredientId;

    private String quantity;

    @Column(name = "measure_type")
    @Enumerated(value = EnumType.STRING)
    private MeasureType measureType;

    public Recipe() {
    }

//    public Recipe(Integer id, Dish dish, Ingredient ingredient, String quantity, MeasureType measureType) {
//        this.id = id;
//        this.dish = dish;
//        this.ingredient = ingredient;
//        this.quantity = quantity;
//        this.measureType = measureType;
//    }

    public Recipe(Integer id, Dish dishId, Ingredient ingredientId, String quantity, MeasureType measureType) {
        this.id = id;
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.measureType = measureType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Ingredient getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Ingredient ingredientId) {
        this.ingredientId = ingredientId;
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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", ingredientId=" + ingredientId +
                ", quantity='" + quantity + '\'' +
                ", measureType=" + measureType +
                '}';
    }
}
