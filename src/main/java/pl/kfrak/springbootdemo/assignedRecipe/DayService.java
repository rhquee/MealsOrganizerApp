package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kfrak.springbootdemo.dish.domain.Dish;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DayService {

    @Autowired
    private DayRepository dayRepository;

    public Day addDay(@RequestBody Day day){
        dayRepository.saveAndFlush(day);
        return day;
    }

    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    public Optional<Day> findDayById(Integer dayId){
        return dayRepository.findById(dayId);
    }
}
