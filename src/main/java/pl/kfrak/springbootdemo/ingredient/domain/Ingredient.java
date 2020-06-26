package pl.kfrak.springbootdemo.ingredient.domain;

import lombok.Data;
import pl.kfrak.springbootdemo.dishingredient.DishIngredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer id;

    @Column(name = "ingredient_name")
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private Set<DishIngredient> dishIngredient = new HashSet<>();

    public Ingredient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DishIngredient> getDishIngredient() {
        return dishIngredient;
    }

    public void setDishIngredient(Set<DishIngredient> dishIngredient) {
        this.dishIngredient = dishIngredient;
    }
}
