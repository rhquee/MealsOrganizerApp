//package pl.kfrak.springbootdemo.dish.dao;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.PreparedStatementCallback;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//import pl.kfrak.springbootdemo.dish.DishRowMapper;
//import pl.kfrak.springbootdemo.dish.domain.Dish;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class DishDaoImpl implements DishDao {
//
//    NamedParameterJdbcTemplate template;
//
//    public DishDaoImpl(NamedParameterJdbcTemplate template) {
//        this.template = template;
//    }
//
//    @Override
//    public List<Dish> findAll() {
//        return template.query("SELECT * FROM \"dish\"h", new DishRowMapper());
//    }
//
//    @Override
//    public void insertDish(Dish dish) {
//        final String sql = "insert into \"dish\"(dish_name) values(:name)";
//
//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("name", dish.getName());
//        template.update(sql, param, holder);
//
//    }
//
//    @Override
//    public void updateDish(Dish dish) {
//        final String sql = "update \"dish\" set dish_name=:name where dish_id=:id";
//
//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("id", dish.getId())
//                .addValue("name", dish.getName());
//        template.update(sql,param, holder);
//
//    }
//
//    @Override
//    public void executeUpdateEmployee(Dish dish) {
//        final String sql = "update public.\"Dish\" set name=:name, ingredients=:ingredients where id=:id";
//
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("employeeId", dish.getId());
//        map.put("employeeName", dish.getName());
//
//        template.execute(sql,map,new PreparedStatementCallback<Object>() {
//            @Override
//            public Object doInPreparedStatement(PreparedStatement ps)
//                    throws SQLException, DataAccessException {
//                return ps.executeUpdate();
//            }
//        });
//
//    }
//
//    @Override
//    public void deleteEmployee(Dish dish) {
//        final String sql = "delete from \"dish\" where dish_id=:id";
//
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("id", dish.getId());
//
//        template.execute(sql,map,new PreparedStatementCallback<Object>() {
//            @Override
//            public Object doInPreparedStatement(PreparedStatement ps)
//                    throws SQLException, DataAccessException {
//                return ps.executeUpdate();
//            }
//        });
//
//    }
//
//}
