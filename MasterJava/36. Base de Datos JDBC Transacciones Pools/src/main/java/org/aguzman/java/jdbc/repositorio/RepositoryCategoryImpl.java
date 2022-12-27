package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCategoryImpl implements Repository<Category> {
  private Connection conn;

  public RepositoryCategoryImpl() {
  }

  public RepositoryCategoryImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public List<Category> list() throws SQLException {
    List<Category> categories = new ArrayList<>();
    String sql = "SELECT * FROM categories";
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Category category = createCategory(rs);
        categories.add(category);
      }
    }
    return categories;
  }

  @Override
  public Category byId(Long id) throws SQLException {
    Category category = new Category();
    String sql = "SELECT * FROM categories WHERE id=?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          category = createCategory(rs);
        }
      }
    }
    return category;
  }

  @Override
  public Category store(Category category) throws SQLException {
    String sql = "";
    if (category.getId() != null && category.getId() > 0) {
      sql = "UPDATE categories SET name=? WHERE id=?";
    } else {
      sql = "INSERT INTO categories(name) VALUES (?)";
    }
    try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      stmt.setString(1, category.getName());
      if (category.getId() != null && category.getId() > 0) {
        stmt.setLong(2, category.getId());
      }
      stmt.executeUpdate();
      if (category.getId() == null) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
          if (rs.next()) {
            category.setId(rs.getLong(1));
          }
        }
      }
    }
    return category;
  }

  @Override
  public void delete(Long id) throws SQLException {
    String sql = "DELETE FROM categories WHERE id=?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    }
  }

  private static Category createCategory(ResultSet rs) throws SQLException {
    Category category = new Category();
    category.setId(rs.getLong("id"));
    category.setName(rs.getString("name"));
    return category;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }
}
