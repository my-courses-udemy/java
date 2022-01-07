package org.bo.optional.example;

import org.bo.optional.example.models.Computer;
import org.bo.optional.example.repository.ComputerRepository;
import org.bo.optional.example.repository.Repository;

import java.util.Optional;

public class ExampleRepository {

    public static void main(String[] args) {
        Repository<Computer> repository = new ComputerRepository();

        repository.filter("asus dg").ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

        /*Optional<Computer> pc = repository.filter("asus rdg");
        if (pc.isPresent()) {
            System.out.println("pc.getName() = " + pc.get());
        } else {
            System.out.println("Not found");
        }*/
    }

}
