package org.bo.optional.example;

import org.bo.optional.example.models.Computer;
import org.bo.optional.example.models.Manufacturer;
import org.bo.optional.example.models.Processor;
import org.bo.optional.example.repository.ComputerRepository;
import org.bo.optional.example.repository.Repository;

public class ExampleRepositoryMethodsMapFilter {

    public static void main(String[] args) {
        Repository<Computer> repository = new ComputerRepository();

//        Method orElse() is always called
        Manufacturer manufacturer = repository.filter("asus rdg")
                /*.map(c -> c.getProcessor())
                .map(p -> p.getManufacturer()).orElseThrow();*/
                .map(Computer::getProcessor)
                .map(Processor::getManufacturer).orElseThrow();
        System.out.println("manufacturer = " + manufacturer);
        
    }

}
