package org.santihs.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable {
  @Id
  @Column(name = "ci")
  private long ci;
  @Column(name = "name")
  private String name;
  @Column(name = "lastname")
  private String lastName;

  public Person() {
  }

  @Override
  public String toString() {
    return "Person{" +
            "ci=" + ci +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
