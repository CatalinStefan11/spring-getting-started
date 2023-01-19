package ro.sda.aop_example_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.aop_example_1.config.ProjectConfig;
import ro.sda.aop_example_1.services.MathService;


/**
 * USEFUL COMMANDS FOR SEARCHING INSIDE THE PROJECT:
 * 
 * CTRL + F = search inside the file that you are currently on
 * CTRL + SHIFT + F = search inside the project (entire project) 
 * SHIFT + SHIFT = search for name of the files, option from intellij (show excluded folders)
 * 
 * 
 */


public class Main {

  public static void main(String[] args) {
    try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      MathService s = c.getBean(MathService.class);
      int res = s.add(10, 5);
      
      int res2 = s.subtract(10, 7);
      
      System.out.println(res);
    }
  }
  
}
