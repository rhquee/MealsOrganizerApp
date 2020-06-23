package pl.kfrak.springbootdemo.dish.domain;

import lombok.Getter;
import lombok.Setter;

import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer dishId;
    @Column(name = "dish_name")
    private String dishName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dish_ingredient",
            joinColumns = {@JoinColumn(name = "dish_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

    void addIngredientToDish(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }
}
