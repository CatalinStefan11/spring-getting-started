package ro.sda.spring_di_4.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

  private String name;
  private Dog dog;
   
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Dog getDog() {
    return dog;
  }

  @Autowired
  public void setDog(Dog dog) {
    this.dog = dog;
  }
  
}