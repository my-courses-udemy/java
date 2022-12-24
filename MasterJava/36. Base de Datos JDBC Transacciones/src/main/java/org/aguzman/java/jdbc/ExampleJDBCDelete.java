package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ExampleJDBCDelete {
    public static void main(String[] args) {
        try (Connection conn = ConnectionDB.getInstance()) {

            Repository<Product> repository = new RepositoryProductImpl();
            System.out.println("============= listar =============");
            repository.list().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repository.byId(1L));

            System.out.println("============= Eliminar producto =============");
            repository.delete(3L);
            System.out.println("Producto eliminado con éxito");
            repository.list().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
