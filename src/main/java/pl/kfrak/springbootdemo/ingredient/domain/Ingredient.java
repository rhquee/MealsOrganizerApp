package pl.kfrak.springbootdemo.ingredient.domain;

import pl.kfrak.springbootdemo.dishingredient.DishIngredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer id;
    @Column(name = "ingredient_name")
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private Set<DishIngredient> dishIngredients = new HashSet<>();

    public Ingredient(String name){
        this.name = name;
    }

    public Ingredient() {
    }
}
