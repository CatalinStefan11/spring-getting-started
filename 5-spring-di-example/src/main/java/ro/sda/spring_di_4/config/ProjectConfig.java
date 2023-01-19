package ro.sda.spring_di_4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ro.sda.spring_di_4.beans")
public class ProjectConfig {
}