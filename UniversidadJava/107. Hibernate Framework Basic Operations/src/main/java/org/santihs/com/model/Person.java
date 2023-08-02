package org.santihs.com.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ci;
  @Column(name = "name")
  private String name;
  @Column(name = "lastname")
  private String lastName;
  @Column(name = "occupied")
  private boolean occupied;

  public Person() {
  }

  public Person(long ci, String name, String lastName, boolean occupied) {
    this.ci = ci;
    this.name = name;
    this.lastName = lastName;
    this.occupied = occupied;
  }

  public long getCi() {
    return ci;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean isOccupied() {
    return occupied;
  }

  public Person(String name, String lastName, boolean occupied) {
    this.name = name;
    this.lastName = lastName;
    this.occupied = occupied;
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
