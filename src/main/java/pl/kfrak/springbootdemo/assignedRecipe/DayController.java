package pl.kfrak.springbootdemo.assignedRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kfrak.springbootdemo.dish.domain.Dish;

@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @PostMapping(value = "/add")
    public ResponseEntity<Day> addDay(@RequestBody Day day){
        Day response = dayService.addDay(day);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
