package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  List<Product> getList();
  Optional<Product> searchProduct(String name);
}
