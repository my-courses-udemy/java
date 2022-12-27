package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.repositorio.RepositoryCategoryImpl;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.service.Service;
import org.aguzman.java.jdbc.service.ServiceCatalog;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class ExampleJDBCService {
  public static void main(String[] args) throws SQLException {
    Service service = new ServiceCatalog();

    System.out.println("============= list =============");
    var list = service.list();
    System.out.println(list);

    System.out.println("============= add new product =============");
    Category category = service.byIdCategory(1L);

    Product product = new Product();
    product.setName("IPhone 5");
    product.setPrice(1200);
    product.setRegisterDate(new Date());
    product.setSku("ABCz12345");
    product.setCategory(category);
    service.store(product);
  }
}
