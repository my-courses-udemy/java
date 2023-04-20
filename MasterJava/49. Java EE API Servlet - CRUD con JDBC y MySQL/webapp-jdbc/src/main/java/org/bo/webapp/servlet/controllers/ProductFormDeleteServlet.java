package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Product;
import org.bo.webapp.servlet.services.ProductService;
import org.bo.webapp.servlet.services.ProductServiceJDBCImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/product/delete")
public class ProductFormDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = (Connection) req.getAttribute("conn");

    ProductService service = new ProductServiceJDBCImpl(connection);

    Long id = (Long) validate(req, "id");

    if (id > 0) {
      Optional<Product> optional = service.searchProductById(id);
      if (optional.isPresent()) {
        service.delete(id);
        resp.sendRedirect(req.getContextPath() + "/products");
      } else {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "There is no this product");
      }
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "The id must be sent in the url");
    }

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
}
