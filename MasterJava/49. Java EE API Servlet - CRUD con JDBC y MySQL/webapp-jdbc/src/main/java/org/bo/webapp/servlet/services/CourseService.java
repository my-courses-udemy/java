package org.bo.webapp.servlet.services;

import org.bo.webapp.servlet.models.Course;
import org.bo.webapp.servlet.models.Product;

import java.util.List;
import java.util.Optional;

public interface CourseService {

  List<Course> getList();

  List<Course> getListByName(String name);

}
