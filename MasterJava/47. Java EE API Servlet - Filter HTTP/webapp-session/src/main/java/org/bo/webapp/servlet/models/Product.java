package org.bo.webapp.servlet.models;

import java.util.Objects;

public class Product {
  private Long id;
  private String name;
  private String type;
  private int price;

  public Product() {
  }

  public Product(Long id, String name, String type, int price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return price == product.price && Objects.equals(id, product.id) && Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }
}
