package ro.sda.spring_di_5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring_di_5.beans.Cat;
import ro.sda.spring_di_5.beans.Owner;
import ro.sda.spring_di_5.config.ProjectConfig;

public class Main {


  public static void main(String[] args) {
    
    try(AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class)){

      Cat c1 = c.getBean(Cat.class);
      Cat c2 = c.getBean(Cat.class);

      System.out.println(c1);
      System.out.println(c2);

      System.out.println("-----------------------");
      
      Owner o = c.getBean(Owner.class);
      Cat c3 = o.getCat();

      System.out.println(o);
      System.out.println(c3);

      System.out.println("-----------------------");
      
      Owner o2 = c.getBean(Owner.class);
      Cat c4 = o2.getCat();

      System.out.println(o2);
      System.out.println(c4);
    }
  }

}
