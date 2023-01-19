package ro.sda.spring_di_5.beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Owner {
  
  @Autowired
  private Cat cat;

  @PostConstruct
  public void init() {
    System.out.println("Owner was created");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Owner is destroying");
  }

  public Cat getCat() {
    return cat;
  }

  public void setCat(Cat cat) {
    this.cat = cat;
  }
}
