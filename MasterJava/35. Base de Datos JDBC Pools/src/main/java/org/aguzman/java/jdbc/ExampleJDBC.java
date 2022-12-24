package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.Connection;

import java.sql.*;
import java.util.Date;

public class ExampleJDBC {
    public static void main(String[] args) {
        try (java.sql.Connection conn = Connection.getConnection()) {

            Repository<Product> repositorio = new RepositoryProductImpl();
            System.out.println("============= listar =============");
            repositorio.list().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.byId(1L));

            System.out.println("============= insertar nuevo producto =============");
            Product producto = new Product();
            producto.setName("Teclado Razer mecánico");
            producto.setPrice(550);
            producto.setRegisterDate(new Date());
            Category categoria = new Category();
            categoria.setId(3L);
            producto.setCategory(categoria);
//            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.list().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
