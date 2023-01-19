package ro.sda.spring_di_3.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Owner {

    private String name;

    @Autowired
    private Dog dog;

    public Owner(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}