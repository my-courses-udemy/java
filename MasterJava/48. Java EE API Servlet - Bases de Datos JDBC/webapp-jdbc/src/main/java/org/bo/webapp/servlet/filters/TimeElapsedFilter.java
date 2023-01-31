package org.bo.webapp.servlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/task-8")
public class TimeElapsedFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    long startTime = System.nanoTime();

    request.setAttribute("time", startTime);
    chain.doFilter(request, response);

  }
}
