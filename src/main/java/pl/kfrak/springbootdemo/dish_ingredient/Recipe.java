package pl.kfrak.springbootdemo.dish_ingredient;

import com.fasterxml.jackson.annotation.*;
import pl.kfrak.springbootdemo.dish.domain.Dish;
import pl.kfrak.springbootdemo.ingredient.domain.Ingredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="dish_ingredient")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    //@ManyToOne(cascade=CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id")
//    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
//    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnoreProperties(value = "recipe", allowSetters = true)
    private Dish dishId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id")
//    @JsonBackReference
//    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
//    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnoreProperties(value = "recipe", allowSetters = true)
    private Ingredient ingredientId;

    private String quantity;

    @Column(name = "measure_type")
    @Enumerated(value = EnumType.STRING)
    private MeasureType measureType;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<AssignedRecipe> assignedRecipe;

    public Recipe() {
    }

    public Recipe(Integer id, Dish dishId, Ingredient ingredientId, String quantity, MeasureType measureType, Set<AssignedRecipe> assignedRecipe) {
        this.id = id;
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.measureType = measureType;
        this.assignedRecipe = assignedRecipe;
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

    public Set<AssignedRecipe> getAssignedRecipe() {
        return assignedRecipe;
    }

    public void setAssignedRecipe(Set<AssignedRecipe> assignedRecipe) {
        this.assignedRecipe = assignedRecipe;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", ingredientId=" + ingredientId +
                ", quantity='" + quantity + '\'' +
                ", measureType=" + measureType +
                ", assignedRecipe=" + assignedRecipe +
                '}';
    }
}

