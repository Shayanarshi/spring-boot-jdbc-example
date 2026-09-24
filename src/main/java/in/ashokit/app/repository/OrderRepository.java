package in.ashokit.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveOrder(int id, LocalDate orderDate,String status){

        String query = "INSERT INTO ORDERS VALUES (?,?,?)";
        jdbcTemplate.update(query,id,orderDate,status);
    }
    public Map<String,Object>fetchOrderById(int id){
        String query = "SELECT * FROM ORDERS WHERE ID = ?";
        return  jdbcTemplate.queryForMap(query,id);
    }
    public  void deleteOrderByID(int id){
        String query = "DELETE FROM ORDERS WHERE ID = ?";
        jdbcTemplate.update(query,id);
    }
}
