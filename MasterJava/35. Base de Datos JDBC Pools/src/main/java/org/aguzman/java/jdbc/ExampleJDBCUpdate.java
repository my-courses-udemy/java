package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.Connection;

import java.sql.SQLException;

public class ExampleJDBCUpdate {
    public static void main(String[] args) {
        try (java.sql.Connection conn = Connection.getConnection()) {

            Repository<Product> repository = new RepositoryProductImpl();
            System.out.println("============= listar =============");
            repository.list().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repository.byId(1L));

            System.out.println("============= editar producto =============");
            Product producto = new Product();
            producto.setId(5L);
            producto.setName("Teclado Cosair k95 mecánico");
            producto.setPrice(700);
            Category category = new Category();
            category.setId(2L);
            producto.setCategory(category);
            repository.store(producto);
            System.out.println("Producto editado con éxito");
            repository.list().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
