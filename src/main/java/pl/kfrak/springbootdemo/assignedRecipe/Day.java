package pl.kfrak.springbootdemo.assignedRecipe;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.kfrak.springbootdemo.assignedRecipe.AssignedRecipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dayOfWeek")
public class Day implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //
    @Column(name = "day_id")
    private Integer id;

    @Column(name = "day_name")
    //@Enumerated(value = EnumType.STRING)
    private String dayName;

    @OneToMany(mappedBy = "dayId", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<AssignedRecipe> assignedRecipe;

    public Day() {
    }

    public Day(int id, String dayName, Set<AssignedRecipe> assignedRecipe) {
        this.id = id;
        this.dayName = dayName;
        this.assignedRecipe = assignedRecipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
