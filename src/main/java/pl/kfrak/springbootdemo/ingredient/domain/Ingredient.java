package pl.kfrak.springbootdemo.ingredient.domain;

import lombok.Getter;
import lombok.Setter;
import pl.kfrak.springbootdemo.dish.domain.Dish;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer id;
    @Column(name = "ingredient_name")
    private String name;

    @ManyToMany (mappedBy = "ingredients", cascade = CascadeType.ALL)
    private Set<Dish> dishes = new HashSet<>();

}
