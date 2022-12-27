package org.aguzman.java.jdbc.service;

import org.aguzman.java.jdbc.modelo.Category;
import org.aguzman.java.jdbc.modelo.Product;

import java.sql.SQLException;
import java.util.List;

public interface Service {
  List<Product> list() throws SQLException;

  Product byId(Long id) throws SQLException;

  Product store(Product product) throws SQLException;

  void delete(Long id) throws SQLException;

  List<Category> listCategory() throws SQLException;

  Category byIdCategory(Long id) throws SQLException;

  Category storeCategory(Category category) throws SQLException;

  void deleteCategory(Long id) throws SQLException;

  void storeProductWithCategory(Product product, Category category) throws SQLException;
}
