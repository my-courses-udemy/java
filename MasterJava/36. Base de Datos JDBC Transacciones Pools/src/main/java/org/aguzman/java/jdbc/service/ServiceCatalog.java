package org.aguzman.java.jdbc.service;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.repositorio.Repository;
import org.aguzman.java.jdbc.repositorio.RepositoryCategoryImpl;
import org.aguzman.java.jdbc.repositorio.RepositoryProductImpl;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServiceCatalog implements Service {
  private Repository<Product> productRepository;
  private Repository<Category> categoryRepository;

  public ServiceCatalog() {
    this.productRepository = new RepositoryProductImpl();
    this.categoryRepository = new RepositoryCategoryImpl();
  }

  @Override
  public List<Product> list() throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      productRepository.setConn(conn);
      return productRepository.list();
    }
  }

  @Override
  public Product byId(Long id) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      productRepository.setConn(conn);
      return productRepository.byId(id);
    }
  }

  @Override
  public Product store(Product product) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      productRepository.setConn(conn);
      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        product = productRepository.store(product);
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }
      return product;
    }
  }

  @Override
  public void delete(Long id) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      productRepository.setConn(conn);
      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        productRepository.delete(id);
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }
    }
  }

  @Override
  public List<Category> listCategory() throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      categoryRepository.setConn(conn);
      return categoryRepository.list();
    }
  }

  @Override
  public Category byIdCategory(Long id) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      categoryRepository.setConn(conn);
      return categoryRepository.byId(id);
    }
  }

  @Override
  public Category storeCategory(Category category) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      categoryRepository.setConn(conn);

      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        category = categoryRepository.store(category);
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }
      return category;
    }
  }

  @Override
  public void deleteCategory(Long id) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      categoryRepository.setConn(conn);
      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        categoryRepository.delete(id);
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }
    }
  }

  @Override
  public void storeProductWithCategory(Product product, Category category) throws SQLException {
    try (Connection conn = ConnectionDB.getConnection()) {
      categoryRepository.setConn(conn);
      productRepository.setConn(conn);

      if (conn.getAutoCommit()) conn.setAutoCommit(false);
      try {
        category = categoryRepository.store(category);
        product.setCategory(category);
        productRepository.store(product);
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        e.printStackTrace();
      }
    }
  }
}
