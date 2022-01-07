package org.bo.optional.example;

import org.bo.optional.example.models.Computer;
import org.bo.optional.example.repository.ComputerRepository;
import org.bo.optional.example.repository.Repository;

public class ExampleRepositoryMethodsOrElse {

    public static void main(String[] args) {
        Repository<Computer> repository = new ComputerRepository();

//        Method orElse() is always called
        Computer pc = repository.filter("asus rdg").orElse(defaultValue());
        System.out.println("pc = " + pc);

        pc = repository.filter("Macbook Pro").orElseGet(ExampleRepositoryMethodsOrElse::defaultValue);
        System.out.println("pc = " + pc);

    }

    public static Computer defaultValue() {
        System.out.println("Return default value");
        return new Computer("Default", "Default");
    }

}
