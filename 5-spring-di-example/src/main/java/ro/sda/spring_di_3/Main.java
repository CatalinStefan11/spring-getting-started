package ro.sda.spring_di_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring_di_3.beans.Dog;
import ro.sda.spring_di_3.beans.Owner;
import ro.sda.spring_di_3.config.ProjectConfig;

public class Main {

  public static void main(String[] args) {
    
    try (var context =
             new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      Owner o = context.getBean(Owner.class);

      Dog d = o.getDog();
      System.out.println(d);

      Dog d2 = context.getBean(Dog.class);
      System.out.println(d2);
    }
  }
}