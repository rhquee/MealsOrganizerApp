//package pl.kfrak.springbootdemo.dish;
//
//import org.springframework.jdbc.core.RowMapper;
//import pl.kfrak.springbootdemo.dish.domain.Dish;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DishRowMapper implements RowMapper<Dish> {
//
//    @Override
//    public Dish mapRow(ResultSet rs, int arg1) throws SQLException {
//        Dish dish = new Dish();
//        dish.setId(rs.getInt("dish_id"));
//        dish.setName(rs.getString("dish_name"));
//
//        return dish;
//    }
//
//
//}
