package pl.kfrak.springbootdemo.dish.domain;

import com.fasterxml.jackson.annotation.*;
import pl.kfrak.springbootdemo.recipe.Recipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="dish")
//@JsonIdentityInfo(generator = ObjectIdGenerator.IdKey.class, property = "@id")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer id;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "dish_description")
    private String dishDescription;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "dishId", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
    @JsonIdentityReference(alwaysAsId = true)
//    @JsonManagedReference
    private Set<Recipe> recipe;

    public Dish() {
    }

    public Dish(Integer id, String dishName, String dishDescription, String notes, Set<Recipe> recipe) {
        this.id = id;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.notes = notes;
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer dishId) {
        this.id = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }
}
