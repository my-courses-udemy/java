package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.database.Repository;
import org.bo.webapp.servlet.database.RepositoryProductImpl;
import org.bo.webapp.servlet.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJDBCImpl implements ProductService {
  private Repository<Product> repository;

  public ProductServiceJDBCImpl(Connection connection) {
    this.repository = new RepositoryProductImpl(connection);
  }

  @Override
  public List<Product> getList() {
    try {
      return repository.list();
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
      return Optional.ofNullable(repository.byId(id));
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }
}
