package ro.sda.aop_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.aop_example.config.ProjectConfig;
import ro.sda.aop_example.services.MathService;

public class Main {

  public static void main(String[] args) {
    try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      MathService s = c.getBean(MathService.class);
      int res = s.add(10, 5);
      System.out.println(res);
    }
  }
  
}
