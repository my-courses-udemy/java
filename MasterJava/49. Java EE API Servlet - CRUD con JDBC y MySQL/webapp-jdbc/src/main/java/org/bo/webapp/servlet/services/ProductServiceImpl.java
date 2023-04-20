package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.models.Category;
import org.bo.webapp.servlet.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
  @Override
  public List<Product> getList() {
//    return Arrays.asList(new Product(1L, "notebook", "computation", 2000),
//            new Product(2L, "desktop", "office", 7000),
//            new Product(3L, "keyboard", "computation", 200));
    return List.of();
  }

  @Override
  public Optional<Product> searchProduct(String name) {
    return getList().stream().filter(product -> product.getName().contains(name)).findFirst();
  }

  @Override
  public Optional<Product> searchProductById(Long id) {
    return getList().stream().filter(product -> product.getId().equals(id)).findAny();
  }

  @Override
  public void store(Product product) {

  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Category> getListCategories() {
    return null;
  }

  @Override
  public Optional<Category> searchCategoryById(Long id) {
    return Optional.empty();
  }
}
