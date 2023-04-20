package org.bo.webapp.servlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.services.ServiceJDBCException;
import org.bo.webapp.servlet.util.ConnectionDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    try (Connection conn = ConnectionDataBase.getConnection()) {
      if (conn.getAutoCommit()) {
        conn.setAutoCommit(false);
      }
      try {
        request.setAttribute("conn", conn);
        chain.doFilter(request, response);
        conn.commit();
      } catch (SQLException | ServiceJDBCException e) {
        conn.rollback();
        ((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        e.printStackTrace();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
