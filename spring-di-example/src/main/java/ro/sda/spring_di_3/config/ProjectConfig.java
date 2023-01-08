package ro.sda.spring_di_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring_di_3.beans.Dog;
import ro.sda.spring_di_3.beans.Owner;

@Configuration
public class ProjectConfig {

  @Bean
  public Owner owner() {
    Owner o = new Owner(null);
    // if we didn't have @Autowired in Owner class 
    //o.setDog(dog());
    o.setName("John");
    return o;
  }

  @Bean
  public Dog dog() {
    Dog d = new Dog();
    d.setName("Pit");
    return d;
  }
}



