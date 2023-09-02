package ro.sda.database_layer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "ro.sda.database_layer.service", "ro.sda.database_layer.repository" })
public class ProjectConfig {
  @Bean
  public DataSource dataSource() {
    var dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
    dataSource.setUsername("root");
    dataSource.setPassword("pass");
    return dataSource;
  }

  // jdbc template bean which simplifies working with jdbc/databases and avoid common errors
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  // object that manages our transactions in the application
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    // we use a predefined version of the transaction manager 
    return new DataSourceTransactionManager(dataSource);
  }
}
