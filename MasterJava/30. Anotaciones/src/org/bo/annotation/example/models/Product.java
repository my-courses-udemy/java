package org.bo.annotation.example.models;

import org.bo.annotation.example.Init;
import org.bo.annotation.example.JsonAttribute;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Product {

    @JsonAttribute(name = "description")
    private String name;
    @JsonAttribute
    private Long price;
    private LocalDate date;

    @Init()
    public void init() {
        this.name = Arrays.stream(name.split(" "))
                .map(element -> element.substring(0, 1).toUpperCase() + element.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.println("name = " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
