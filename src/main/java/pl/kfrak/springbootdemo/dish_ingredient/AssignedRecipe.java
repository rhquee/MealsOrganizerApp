package pl.kfrak.springbootdemo.dish_ingredient;

import javax.persistence.*;

@Entity
@Table(name = "assigned_recipe")
public class AssignedRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
    private Day day;

    private String mealType;
}
