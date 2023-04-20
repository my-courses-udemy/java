package org.bo.webapp.servlet.database;

import org.bo.webapp.servlet.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCategoryImpl implements Repository<Category> {

  private Connection connection;
  private static final String SQL_LIST = "SELECT * FROM categories";
  private static final String SQL_BY_ID = SQL_LIST + " AS c WHERE c.id=?";

  public RepositoryCategoryImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Category> list() throws SQLException {
    List<Category> categories = new ArrayList<>();
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(SQL_LIST)) {
      while (rs.next()) {
        Category category = getCategory(rs);

        categories.add(category);
      }
    }
    return categories;
  }

  @Override
  public Category byId(Long id) throws SQLException {
    Category category = null;
    try (PreparedStatement stmt = connection.prepareStatement(SQL_BY_ID)) {
      stmt.setLong(1, id);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          category = getCategory(rs);
        }
      }
    }
    return category;
  }

  @Override
  public void store(Category category) throws SQLException {

  }

  @Override
  public void delete(Long id) throws SQLException {

  }

  private static Category getCategory(ResultSet rs) throws SQLException {
    Category category = new Category();
    category.setId(rs.getLong("id"));
    category.setName(rs.getString("name"));
    return category;
  }
}
