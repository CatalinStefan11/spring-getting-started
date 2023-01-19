package ro.sda.product_app.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.product_app.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class ProductRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PostConstruct
  public void initDatabase() {
    String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, name varchar(255), description varchar(255))";
    jdbcTemplate.update(sql);
    log.info("Database created");
  }

  @PreDestroy
  void dropDatabase() {
    String sql = "DROP TABLE product";
    jdbcTemplate.update(sql);
  }

  public void addProduct(String name, String description) {
    String sql = "INSERT INTO product(name, description) VALUES(?, ?)";
    jdbcTemplate.update(sql, name, description);
  }

  public List<Product> getAllProducts() {
    String sql = "SELECT * FROM product";
    return jdbcTemplate.query(sql, (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
  }

  public Product getById(int id) {
    String sql = "SELECT * FROM product WHERE ID = ?";
    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description")), id);
  }
}
