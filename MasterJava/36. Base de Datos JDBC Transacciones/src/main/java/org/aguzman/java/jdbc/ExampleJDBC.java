package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.*;
import java.util.Date;

public class ExampleJDBC {
    public static void main(String[] args) {
        try (Connection conn = ConnectionDB.getInstance()) {

            Repository<Product> repository = new RepositoryProductImpl();
            System.out.println("============= listar =============");
            repository.list().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repository.byId(1L));

            System.out.println("============= insertar nuevo producto =============");
            Product producto = new Product();
            producto.setName("Teclado Razer mecánico");
            producto.setPrice(550);
            producto.setRegisterDate(new Date());
            Category category = new Category();
            category.setId(3L);
            producto.setCategory(category);
//            repository.store(producto);
            System.out.println("Producto guardado con éxito");
            repository.list().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
