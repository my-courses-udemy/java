package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Category;
import org.bo.webapp.servlet.models.Product;
import org.bo.webapp.servlet.services.ProductService;
import org.bo.webapp.servlet.services.ProductServiceJDBCImpl;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/product-form")
public class ProductFormServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = (Connection) req.getAttribute("conn");
    ProductService service = new ProductServiceJDBCImpl(connection);

    Long id = (Long) validate(req, "id");

    Product product = new Product();
    product.setCategory(new Category());

    if (id > 0) {
      Optional<Product> optional = service.searchProductById(id);
      if (optional.isPresent()) product = optional.get();
    }

    req.setAttribute("categories", service.getListCategories());
    req.setAttribute("product", product);
    getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = (Connection) req.getAttribute("conn");

    ProductService service = new ProductServiceJDBCImpl(connection);

    String name = req.getParameter("name");

    Integer price = validate(req, "price").intValue();

    String sku = req.getParameter("sku");
    String registerDate = req.getParameter("register_date");

    Long categoryId = (Long) validate(req, "category");

    Map<String, String> errors = createErrors(name, price, sku, registerDate, categoryId);

    LocalDate date = validateDate(registerDate);

    Long id = (Long) validate(req, "id");

    Product product = createProduct(name, price, sku, categoryId, date);
    product.setId(id);

    if (errors.isEmpty()) {
      service.store(product);
      resp.sendRedirect(req.getContextPath() + "/products");
    } else {
      req.setAttribute("errors", errors);
      req.setAttribute("categories", service.getListCategories());
      req.setAttribute("product", product);
      getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }
  }

  private static LocalDate validateDate(String registerDate) {
    LocalDate date;
    try {
      date = LocalDate.parse(registerDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    } catch (DateTimeParseException e) {
      date = null;
    }
    return date;
  }

  private static Number validate(HttpServletRequest req, String attribute) {
    Number categoryId;
    try {
      categoryId = Long.parseLong(req.getParameter(attribute));
    } catch (NumberFormatException e) {
      categoryId = 0L;
    }
    return categoryId;
  }

  private static Map<String, String> createErrors(String name, Integer price, String sku, String registerDate, Long categoryId) {
    Map<String, String> errors = new HashMap<>();
    if (name == null || name.isBlank()) {
      errors.put("name", "The name can't be empty");
    }
    if (sku == null || sku.isBlank()) {
      errors.put("sku", "The sku can't be empty");
    } else if (sku.length() > 10) {
      errors.put("sku", "The sku must have a max size 10");
    }
    if (registerDate == null || registerDate.isBlank()) {
      errors.put("register_date", "The register date can't be empty");
    }
    if (price.equals(0)) {
      errors.put("price", "The price can't be empty");
    }
    if (categoryId.equals(0L)) {
      errors.put("category", "The category can't be empty");
    }
    return errors;
  }

  private static Product createProduct(String name, Integer price, String sku, Long categoryId, LocalDate date) {
    Product product = new Product();
    product.setName(name);
    product.setPrice(price);
    product.setSku(sku);
    product.setRegisterDate(date);

    Category category = new Category();
    category.setId(categoryId);
    product.setCategory(category);
    return product;
  }
}
