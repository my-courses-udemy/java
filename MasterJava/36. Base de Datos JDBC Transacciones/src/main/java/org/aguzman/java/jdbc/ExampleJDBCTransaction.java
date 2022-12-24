package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class ExampleJDBCTransaction {
  public static void main(String[] args) throws SQLException {
    try (Connection conn = ConnectionDB.getInstance()) {
      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        Repository<Product> repository = new RepositoryProductImpl();
        System.out.println("============= list =============");
        repository.list().forEach(System.out::println);

        System.out.println("============= new product =============");
        Product product = new Product();
        product.setName("Keyboard IBM mecánico");
        product.setPrice(550);
        product.setRegisterDate(new Date());
        product.setSku("ABCE12345");
        Category category = new Category();
        category.setId(1L);
        product.setCategory(category);
        repository.store(product);

        System.out.println("============= edit product =============");
        product = new Product();
        product.setId(2L);
        product.setName("Keyboard LIBM mecánico");
        product.setPrice(550);
        product.setRegisterDate(new Date());
        product.setSku("ABCg12345");
        category = new Category();
        category.setId(1L);
        product.setCategory(category);
        repository.store(product);
        repository.list().forEach(System.out::println);

        conn.commit();
      } catch (SQLException e) {
        e.printStackTrace();
        conn.rollback();
      }
    }
  }
}
