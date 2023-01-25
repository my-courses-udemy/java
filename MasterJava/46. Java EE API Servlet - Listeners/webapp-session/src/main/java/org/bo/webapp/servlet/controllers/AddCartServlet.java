package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bo.webapp.servlet.models.Cart;
import org.bo.webapp.servlet.models.ItemCart;
import org.bo.webapp.servlet.services.ProductService;
import org.bo.webapp.servlet.services.ProductServiceImpl;

import java.io.IOException;

@WebServlet("/add-cart")
public class AddCartServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id = Long.valueOf(req.getParameter("id"));

    ProductService service = new ProductServiceImpl();
    var optional = service.searchProductById(id);

    if (optional.isPresent()) {
      ItemCart itemCart = new ItemCart(1, optional.get());
      HttpSession session = req.getSession();
      Cart cart = (Cart) session.getAttribute("cart");

      cart.addItem(itemCart);
    }
    resp.sendRedirect(req.getContextPath() + "/see-cart");
  }
}
