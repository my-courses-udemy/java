package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.database.Repository;
import org.bo.webapp.servlet.database.RepositoryByString;
import org.bo.webapp.servlet.database.RepositoryCourseImpl;
import org.bo.webapp.servlet.models.Course;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class CourseServiceJDBCImpl implements CourseService {

  private Repository<Course> repository;

  public CourseServiceJDBCImpl(Connection connection) {
    this.repository = new RepositoryCourseImpl(connection);
  }

  @Override
  public List<Course> getList() {
    try {
      return repository.list();
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public List<Course> getListByName(String name) {
    try {
      return ((RepositoryByString<Course>) repository).byName(name);
    } catch (SQLException e) {
      throw new ServiceJDBCException(e.getMessage(), e.getCause());
    }
  }
}
