package ro.sda.spring_di_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring_di_2.beans.Dog;
import ro.sda.spring_di_2.beans.Owner;

@Configuration
public class ProjectConfig {

  @Bean
  public Owner owner() {
    Owner o = new Owner();
    o.setDog(dog());
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