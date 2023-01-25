package org.bo.webapp.servlet.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<ItemCart> items;

  public Cart() {
    items = new ArrayList<>();
  }

  public void addItem(ItemCart itemCart) {
    if (items.contains(itemCart)) {
      var optional = items.stream()
              .filter(item -> item.equals(itemCart))
              .findFirst();
      optional.ifPresent(item -> item.setQuantity(item.getQuantity() + 1));
      return;
    }
    items.add(itemCart);
  }

  public List<ItemCart> getItems() {
    return items;
  }

  public int getTotal() {
    return items.stream().mapToInt(ItemCart::getTotal).sum();
  }
}
