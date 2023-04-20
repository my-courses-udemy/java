package org.bo.webapp.servlet.database;

import org.bo.webapp.servlet.models.Category;
import org.bo.webapp.servlet.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements Repository<Product> {
  private Connection conn;
  private static final String SQL_LIST = "SELECT p.*, c.name as category FROM products as p " +
          " INNER JOIN categories as c ON (p.category_id = c.id) ORDER BY p.id ";
  private static final String SQL_BY_ID = "SELECT p.*, c.name as category FROM products as p "
          + "INNER JOIN categories as c ON (p.category_id = c.id) "
          + " where p.id = ?";
  private static final String SQL_UPDATE = "UPDATE products SET name=?, price=?, sku=?, category_id=? WHERE id=?";
  private static final String SQL_INSERT = "INSERT INTO products (name, price, sku, category_id, register_date) VALUES " +
          "(?,?,?,?,?)";
  private static final String SQL_DELETE = "DELETE FROM products WHERE id=?";

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
    String sql;
    if (product.getId() != null && product.getId() > 0) {
      sql = SQL_UPDATE;
    } else {
      sql = SQL_INSERT;
    }

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getPrice());
      stmt.setString(3, product.getSku());
      stmt.setLong(4, product.getCategory().getId());
      if (product.getId() != null && product.getId() > 0) {
        stmt.setLong(5, product.getId());
      } else {
        stmt.setDate(5, Date.valueOf(product.getRegisterDate()));
      }
      stmt.executeUpdate();
    }
  }

  @Override
  public void delete(Long id) throws SQLException {
    try (PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    }
  }

  private static Product getProduct(ResultSet rs) throws SQLException {
    Product product = new Product();
    product.setId(rs.getLong("id"));
    product.setName(rs.getString("name"));
    product.setPrice(rs.getInt("price"));

    Category category = new Category();
    category.setId(rs.getLong("category_id"));
    category.setName(rs.getString("category"));

    product.setCategory(category);
    product.setSku(rs.getString("sku"));
    product.setRegisterDate(rs.getDate("register_date").toLocalDate());
    return product;
  }
}
