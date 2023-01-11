package ro.sda.aop_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ro.sda.aop_example.aspects.MathServiceAspect;

@Configuration
@ComponentScan(basePackages = "ro.sda.aop_example.services")
@EnableAspectJAutoProxy
public class ProjectConfig {

  @Bean
  public MathServiceAspect aspect() {
    return new MathServiceAspect();
  }
}
