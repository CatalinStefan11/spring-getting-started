package ro.sda.database_layer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.database_layer.mapper.ProductRowMapper;
import ro.sda.database_layer.model.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    void initDatabase(){
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, name varchar(255))";
        jdbcTemplate.update(sql);
        
        
    }
    
    @PreDestroy
    void dropDatabase(){
        String sql = "DROP TABLE product";
        jdbcTemplate.update(sql);
    }

    public void addProduct(String name) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }
    
    public void addProductExceptionWithoutTransaction(String name) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, name);
        throw new RuntimeException();
    }

    @Transactional
    public void addProductExceptionWithTx(String name) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, name);
        throw new RuntimeException();
    }


    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
}