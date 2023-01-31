package org.bo.webapp.servlet.database;

import org.bo.webapp.servlet.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements Repository<Product> {
  private Connection conn;
  private static final String SQL_LIST = "SELECT p.*, c.name as category FROM products as p " +
          " INNER JOIN categories as c ON (p.category_id = c.id)";
  private static final String SQL_BY_ID = SQL_LIST + " where p.id = ?";

  public RepositoryProductImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public List<Product> list() throws SQLException {
    List<Product> products = new ArrayList<>();
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL_LIST)) {
      while (rs.next()) {
        Product product = getProduct(rs);

        products.add(product);
      }
    }
    return products;
  }

  @Override
  public Product byId(Long id) throws SQLException {
    Product product = null;
    try (PreparedStatement stmt = conn.prepareStatement(SQL_BY_ID)) {
      stmt.setLong(1, id);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          product = getProduct(rs);
        }
      }
    }
    return product;
  }

  @Override
  public void store(Product product) throws SQLException {

  }

  @Override
  public void delete(Long id) throws SQLException {

  }

  private static Product getProduct(ResultSet rs) throws SQLException {
    Product product = new Product();
    product.setId(rs.getLong("id"));
    product.setName(rs.getString("name"));
    product.setPrice(rs.getInt("price"));
    product.setType(rs.getString("category"));
    return product;
  }
}
