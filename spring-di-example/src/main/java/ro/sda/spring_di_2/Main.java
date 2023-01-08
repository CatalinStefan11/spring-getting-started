package ro.sda.spring_di_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring_di_2.beans.Dog;
import ro.sda.spring_di_2.beans.Owner;
import ro.sda.spring_di_2.config.ProjectConfig;

public class Main {

  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context =
             new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      Owner o = context.getBean(Owner.class);

      System.out.println(o);

      Dog d = o.getDog();
      System.out.println(d);

      Dog d2 = context.getBean(Dog.class);
      System.out.println(d2);

      System.out.println(o);
    }
  }
}
