package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.models.Category;
import org.bo.webapp.servlet.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  List<Product> getList();

  Optional<Product> searchProduct(String name);

  Optional<Product> searchProductById(Long id);

  void store(Product product);

  void delete(Long id);

  List<Category> getListCategories();

  Optional<Category> searchCategoryById(Long id);
}
