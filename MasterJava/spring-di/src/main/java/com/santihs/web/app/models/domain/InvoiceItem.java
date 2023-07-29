package com.santihs.web.app.models.domain;

public class InvoiceItem {
  private Product product;
  private int quantity;

  public InvoiceItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int calculateTotal() {
    return product.getPrice() * quantity;
  }
}
