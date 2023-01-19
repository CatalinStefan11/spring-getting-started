package ro.sda.aop_example_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ro.sda.aop_example_1.aspects.MathServiceAspect;

@Configuration
@ComponentScan(basePackages = "ro.sda.aop_example_1.services")
@EnableAspectJAutoProxy
public class ProjectConfig {

  @Bean
  public MathServiceAspect aspect() {
    return new MathServiceAspect();
  }
}
