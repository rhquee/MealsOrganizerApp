package pl.kfrak.springbootdemo.dish_ingredient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "day_name")
    //@Enumerated(value = EnumType.STRING)
    private String dayName;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private Set<AssignedRecipe> assignedRecipe;

    public Day() {
    }

    public Day(int id, String dayName, Set<AssignedRecipe> assignedRecipe) {
        this.id = id;
        this.dayName = dayName;
        this.assignedRecipe = assignedRecipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Set<AssignedRecipe> getAssignedRecipe() {
        return assignedRecipe;
    }

    public void setAssignedRecipe(Set<AssignedRecipe> assignedRecipe) {
        this.assignedRecipe = assignedRecipe;
    }
}

//enum DayName {
//    PONIEDZIAŁEK, WTOREK, ŚRODA, CZWARTEK, PIĄTEK, SOBOTA, NIEDZIELA
//}
