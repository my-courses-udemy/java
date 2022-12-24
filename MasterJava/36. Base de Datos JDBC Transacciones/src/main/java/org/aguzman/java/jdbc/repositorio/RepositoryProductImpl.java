package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;
import org.aguzman.java.jdbc.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements Repository<Product> {

  private Connection getConnection() throws SQLException {
    return ConnectionDB.getInstance();
  }

  @Override
  public List<Product> list() throws SQLException {
    List<Product> products = new ArrayList<>();

    try (Statement stmt = getConnection().createStatement();
         ResultSet rs = stmt.executeQuery("SELECT p.*, c.name as category FROM products as p " +
                 "inner join categories as c ON (p.category_id = c.id)")) {
      while (rs.next()) {
        Product p = createProducts(rs);
        products.add(p);
      }
    }
    return products;
  }


  @Override
  public Product byId(Long id) throws SQLException {
    Product product = null;

    try (PreparedStatement stmt = getConnection().
            prepareStatement("SELECT p.*, c.name as category FROM products as p " +
                    "inner join categories as c ON (p.category_id = c.id) WHERE p.id = ?")) {
      stmt.setLong(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          product = createProducts(rs);
        }
      }
    }
    return product;
  }

  @Override
  public void store(Product product) throws SQLException {
    String sql;
    if (product.getId() != null && product.getId() > 0) {
      sql = "UPDATE products SET name=?, price=?, category_id=?, sku=? WHERE id=?";
    } else {
      sql = "INSERT INTO products(name, price, category_id, sku, register_date) VALUES(?,?,?,?,?)";
    }
    try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
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
    }

  }

  @Override
  public void delete(Long id) throws SQLException {
    try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM products WHERE id=?")) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    }
  }

  private Product createProducts(ResultSet rs) throws SQLException {
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
}
