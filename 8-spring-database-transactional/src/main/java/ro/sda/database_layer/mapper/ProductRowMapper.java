package ro.sda.database_layer.mapper;

import org.springframework.jdbc.core.RowMapper;
import ro.sda.database_layer.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

  @Override
  public Product mapRow(ResultSet resultSet, int i) throws SQLException {
    Product p = new Product();
    p.setId(resultSet.getInt("id"));
    p.setName(resultSet.getString("name"));
    return p;
  }
}