package org.bo.webapp.servlet.database;

import org.bo.webapp.servlet.models.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCourseImpl implements Repository<Course>, RepositoryByString<Course> {
  private Connection conn;
  private static final String SQL_LIST = "SELECT * FROM courses";
  private static final String SQL_BY_NAME = "SELECT * FROM courses AS c WHERE c.name like ?";

  public RepositoryCourseImpl(Connection connection) {
    this.conn = connection;
  }

  @Override
  public List<Course> list() throws SQLException {
    List<Course> courses = new ArrayList<>();
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL_LIST)) {
      while (rs.next()) {
        Course course = getCourse(rs);

        courses.add(course);
      }
    }
    return courses;
  }

  @Override
  public Course byId(Long id) throws SQLException {
    return null;
  }

  @Override
  public void store(Course course) throws SQLException {

  }

  @Override
  public void delete(Long id) throws SQLException {

  }

  @Override
  public List<Course> byName(String text) throws SQLException {
    List<Course> courses = new ArrayList<>();
    try (PreparedStatement stmt = conn.prepareStatement(SQL_BY_NAME)) {
      stmt.setString(1, "%" + text + "%");
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          Course course = getCourse(rs);

          courses.add(course);
        }
      }
    }
    return courses;
  }

  private static Course getCourse(ResultSet rs) throws SQLException {
    Course course = new Course();
    course.setId(rs.getInt("id"));
    course.setName(rs.getString("name"));
    course.setDescription(rs.getString("description"));
    course.setInstructor(rs.getString("instructor"));
    course.setDuration(rs.getDouble("duration"));
    return course;
  }
}
