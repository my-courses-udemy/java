package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.database.Repository;
import org.bo.webapp.servlet.database.RepositoryCategoryImpl;
import org.bo.webapp.servlet.database.RepositoryProductImpl;
import org.bo.webapp.servlet.models.Category;
import org.bo.webapp.servlet.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJDBCImpl implements ProductService {
  private Repository<Product> productRepository;
  private Repository<Category> categoryRepository;

  public ProductServiceJDBCImpl(Connection connection) {
    this.productRepository = new RepositoryProductImpl(connection);
    this.categoryRepository = new RepositoryCategoryImpl(connection);
  }

  @Override
  public List<Product> getList() {
    try {
      return productRepository.list();
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public Optional<Product> searchProduct(String name) {
    return Optional.empty();
  }

  @Override
  public Optional<Product> searchProductById(Long id) {
    try {
      return Optional.ofNullable(productRepository.byId(id));
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public void store(Product product) {
    try {
      productRepository.store(product);
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public void delete(Long id) {
    try {
      productRepository.delete(id);
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public List<Category> getListCategories() {
    try {
      return categoryRepository.list();
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public Optional<Category> searchCategoryById(Long id) {
    try {
      return Optional.ofNullable(categoryRepository.byId(id));
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }
}
