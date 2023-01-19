package ro.sda.product_app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class ProjectConfig {

  @Value("${spring.datasource.url}")
  private String dataSourceUrl;

  @Value("${spring.datasource.driverClassName}")
  private String dbDriver;

  @Value("${spring.datasource.username}")
  private String dbUser;

  @Value("${spring.datasource.password}")
  private String dbPass;
  
  @Bean
  public DataSource dataSource() {
    log.info("Database driver {}", dbDriver);
    log.info("Database url {}", dataSourceUrl);
    log.info("Database user {}", dbUser);
    // this is not a good practice to log the password, but we do it for learning purposes
    log.info("Database password {}", dbPass);

    var dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(dbDriver);
    dataSource.setUrl(dataSourceUrl);
    dataSource.setUsername(dbUser);
    dataSource.setPassword(dbPass);
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
}
