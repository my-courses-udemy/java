package org.bo.webapp.servlet.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.bo.webapp.servlet.models.Cart;

@WebListener
public class AppListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
  private ServletContext servletContext;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("App initialized");
    servletContext = sce.getServletContext();
    servletContext.setAttribute("message", "A global value");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    servletContext.log("App destroyed");
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    servletContext.log("Request initialized");
    sre.getServletRequest().setAttribute("message", "Message in the request");
    sre.getServletRequest().setAttribute("name", "Santiago");
    sre.getServletRequest().setAttribute("lastname", "Sanchez");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    servletContext.log("Request destroyed");
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    servletContext.log("Session created");
    Cart cart = new Cart();
    HttpSession session = se.getSession();
    session.setAttribute("cart", cart);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    servletContext.log("Session destroyed");
  }
}
