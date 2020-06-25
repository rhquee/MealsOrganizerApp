package pl.kfrak.springbootdemo.dish.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import pl.kfrak.springbootdemo.dishingredient.DishIngredient;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
//@Getter
//@Setter
@Entity(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer dishId;
    @Column(name = "dish_name")
    private String dishName;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<DishIngredient> dishIngredient;

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

    public Set<DishIngredient> getDishIngredient() {
        return dishIngredient;
    }

    public void setDishIngredient(Set<DishIngredient> dishIngredient) {
        this.dishIngredient = dishIngredient;
    }

//    public Dish(String dishName, DishIngredient... dishIngredients){
//        this.dishName = dishName;
//        for(DishIngredient dishIngredient : dishIngredients) dishIngredient.setDish(this);
//        this.dishIngredient = Stream.of(dishIngredients).collect(Collectors.toSet());
//    }
    public Dish(String name) {
        this.dishName = name;
        dishIngredient = new HashSet<>();
}
}
