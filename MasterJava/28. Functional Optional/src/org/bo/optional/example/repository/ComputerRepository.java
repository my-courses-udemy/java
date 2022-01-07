package org.bo.optional.example.repository;

import org.bo.optional.example.models.Computer;
import org.bo.optional.example.models.Manufacturer;
import org.bo.optional.example.models.Processor;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerRepository implements Repository {

    private List<Computer> dataSource;

    public ComputerRepository() {
        this.dataSource = new ArrayList<>();

        Processor processor = new Processor("I9-9880H", new Manufacturer("Intel"));
        Computer asus = new Computer("Asus RDG", "Strix G512");
        asus.setProcessor(processor);
        this.dataSource.add(asus);
        this.dataSource.add(new Computer("Macbook Pro", "MVVk2CI"));
    }

    @Override
    public Optional<Computer> filter(String name) {
        return dataSource.stream().filter(computer -> computer.getName().equalsIgnoreCase(name))
                .findFirst();
        /*for (Computer computer : dataSource) {
            if (computer.getName().equalsIgnoreCase(name)) {
                return Optional.of(computer);
            }
        }
        return Optional.empty();*/
    }
}
