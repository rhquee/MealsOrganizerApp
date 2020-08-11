package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Integer> {
}
