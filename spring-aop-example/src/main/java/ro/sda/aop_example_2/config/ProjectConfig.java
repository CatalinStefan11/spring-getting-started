package ro.sda.aop_example_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"ro.sda.aop_example_2.service", "ro.sda.aop_example_2.aspect"})
@EnableAspectJAutoProxy
public class ProjectConfig {


}
