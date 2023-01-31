package org.bo.webapp.servlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.services.LoginService;
import org.bo.webapp.servlet.services.LoginServiceSessionImpl;

import java.io.IOException;

@WebFilter({"/see-cart", "/add-cart"})
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {
    LoginService service = new LoginServiceSessionImpl();
    var username = service.getUsername((HttpServletRequest) request);
    if (username.isPresent()) {
      chain.doFilter(request, response);
      return;
    }
    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "You're not authorized");
  }

}
