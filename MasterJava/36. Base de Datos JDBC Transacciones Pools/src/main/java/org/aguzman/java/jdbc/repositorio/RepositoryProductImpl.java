package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements Repository<Product> {

  private java.sql.Connection conn;

  public RepositoryProductImpl() {
  }

  public RepositoryProductImpl(java.sql.Connection conn) {
    this.conn = conn;
  }

  @Override
  public List<Product> list() throws SQLException {
    List<Product> products = new ArrayList<>();

    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT p.*, c.name as category FROM products as p " +
                 "inner join categories as c ON (p.category_id = c.id)")) {
      while (rs.next()) {
        Product p = createProduct(rs);
        products.add(p);
      }
    }
    return products;
  }


  @Override
  public Product byId(Long id) throws SQLException {
    Product product = null;

    try (PreparedStatement stmt = conn.
            prepareStatement("SELECT p.*, c.name as category FROM products as p " +
                    "inner join categories as c ON (p.category_id = c.id) WHERE p.id = ?")) {
      stmt.setLong(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          product = createProduct(rs);
        }
      }
    }
    return product;
  }

  @Override
  public Product store(Product product) throws SQLException {
    String sql;
    if (product.getId() != null && product.getId() > 0) {
      sql = "UPDATE products SET name=?, price=?, category_id=?, sku=? WHERE id=?";
    } else {
      sql = "INSERT INTO products(name, price, category_id, sku, register_date) VALUES(?,?,?,?,?)";
    }
    try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
      stmt.setString(1, product.getName());
      stmt.setLong(2, product.getPrice());
      stmt.setLong(3, product.getCategory().getId());
      stmt.setString(4, product.getSku());

      if (product.getId() != null && product.getId() > 0) {
        stmt.setLong(5, product.getId());
      } else {
        stmt.setDate(5, new Date(product.getRegisterDate().getTime()));
      }

      stmt.executeUpdate();
      if (product.getId() == null) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
          if (rs.next()) {
            product.setId(rs.getLong(1));
          }
        }
      }
      return product;
    }
  }

  @Override
  public void delete(Long id) throws SQLException {
    try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id=?")) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    }
  }

  private Product createProduct(ResultSet rs) throws SQLException {
    Product p = new Product();
    p.setId(rs.getLong("id"));
    p.setName(rs.getString("name"));
    p.setPrice(rs.getInt("price"));
    p.setRegisterDate(rs.getDate("register_date"));
    p.setSku(rs.getString("sku"));
    Category category = new Category();
    category.setId(rs.getLong("category_id"));
    category.setName(rs.getString("category"));
    p.setCategory(category);
    return p;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }
}
