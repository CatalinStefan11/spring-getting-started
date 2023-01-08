package ro.sda.spring_di_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring_di_4.beans.Dog;
import ro.sda.spring_di_4.beans.Owner;
import ro.sda.spring_di_4.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {
        try (var context =
                new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = context.getBean(Owner.class);
            System.out.println(o.getDog());

            Dog d = context.getBean(Dog.class);
            System.out.println(d);
        }
    }
}