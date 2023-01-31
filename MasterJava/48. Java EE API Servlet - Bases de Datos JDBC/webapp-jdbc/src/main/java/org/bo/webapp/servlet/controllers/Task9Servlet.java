package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Course;
import org.bo.webapp.servlet.services.CourseService;
import org.bo.webapp.servlet.services.CourseServiceJDBCImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/task-9")
public class Task9Servlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = (Connection) req.getAttribute("conn");
    String filter = req.getParameter("filter");

    List<Course> courses;
    CourseService service = new CourseServiceJDBCImpl(connection);
    courses = (filter == null) ? service.getList() : service.getListByName(filter);

    req.setAttribute("courses", courses);
    getServletContext().getRequestDispatcher("/task-9.jsp").forward(req, resp);
  }

}
