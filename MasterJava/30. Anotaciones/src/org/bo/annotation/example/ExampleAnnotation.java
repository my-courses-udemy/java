package org.bo.annotation.example;

import org.bo.annotation.example.models.Product;
import org.bo.annotation.example.processor.JsonSerializer;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class ExampleAnnotation {

    public static void main(String[] args) {
        Product product = new Product();
        product.setDate(LocalDate.now());
        product.setName("oak coffee TABLE");
        product.setPrice(1000L);

        String json = JsonSerializer.convertJson(product);
        System.out.println("json = " + json);
    }

}
