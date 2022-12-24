package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ExampleJDBCUpdate {
  public static void main(String[] args) {
    try (Connection conn = ConnectionDB.getInstance()) {

      Repository<Product> repositorio = new RepositoryProductImpl();
      System.out.println("============= listar =============");
      repositorio.list().forEach(System.out::println);

      System.out.println("============= obtener por id =============");
      System.out.println(repositorio.byId(1L));

      System.out.println("============= editar producto =============");
      Product producto = new Product();
      producto.setId(5L);
      producto.setName("Teclado Cosair k95 mecánico");
      producto.setPrice(700);
      Category categoria = new Category();
      categoria.setId(2L);
      producto.setCategory(categoria);
      repositorio.store(producto);
      System.out.println("Producto editado con éxito");
      repositorio.list().forEach(System.out::println);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
