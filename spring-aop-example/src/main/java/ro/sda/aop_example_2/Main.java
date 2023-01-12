package ro.sda.aop_example_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ro.sda.aop_example_2.config.ProjectConfig;
import ro.sda.aop_example_2.service.AccountInfoService;

public class Main {

  public static void main(String[] args) {
    try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      AccountInfoService s = c.getBean(AccountInfoService.class);
      s.getAccountInfo();
    }
  }
  
}
