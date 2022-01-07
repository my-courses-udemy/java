package org.bo.optional.example;

import org.bo.optional.example.models.Computer;
import org.bo.optional.example.repository.ComputerRepository;
import org.bo.optional.example.repository.Repository;

import java.util.Optional;

public class ExampleRepositoryMethodsOrElseThrow {

    public static void main(String[] args) {
        Repository<Computer> repository = new ComputerRepository();

//        Method orElse() is always called
        Computer pc = repository.filter("asus rdg").orElseThrow(() -> new IllegalStateException("Hola"));
        System.out.println("pc = " + pc);

        String file = "Documents.pdf";
        String extension = Optional.ofNullable(file)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(file.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);

    }



}
