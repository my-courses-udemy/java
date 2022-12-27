package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.RepositoryCategoryImpl;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.*;
import java.util.Date;

public class ExampleJDBC {
  public static void main(String[] args) throws SQLException {
    try (java.sql.Connection conn = ConnectionDB.getConnection()) {
      if (conn.getAutoCommit()) {
        conn.setAutoCommit(false);
      }
      try {
        Repository<Category> categoryRepository = new RepositoryCategoryImpl(conn);
        Repository<Product> repositorio = new RepositoryProductImpl(conn);

        System.out.println("============= listar =============");
        repositorio.list().forEach(System.out::println);

        System.out.println("============= obtener por id =============");
        System.out.println(repositorio.byId(1L));

        System.out.println("============= add new category =============");
        Category category = new Category();
        category.setName("Home appliances");
        Category newCAtegory = categoryRepository.store(category);
        System.out.println(newCAtegory);

        category = categoryRepository.byId(1L);

        System.out.println("============= add new product =============");
        Product product = new Product();
        product.setName("IPhone 4");
        product.setPrice(2200);
        product.setRegisterDate(new Date());
        product.setSku("ABCz12345");

        product.setCategory(category);
        product = repositorio.store(product);
        System.out.println(product);

        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }

    }
  }
}
