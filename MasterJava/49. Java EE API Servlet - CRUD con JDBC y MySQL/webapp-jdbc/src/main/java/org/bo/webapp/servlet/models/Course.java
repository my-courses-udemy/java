package org.bo.webapp.servlet.models;

public class Course {
  private Integer id;
  private String name;
  private String description;
  private String instructor;
  private Double duration;

  public Course(Integer id, String name, String description, String instructor, Double duration) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.instructor = instructor;
    this.duration = duration;
  }

  public Course() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }
}
