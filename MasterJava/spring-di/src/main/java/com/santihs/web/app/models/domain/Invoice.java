package com.santihs.web.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
// ? This bean wil last for the duration  of an http request
//@RequestScope
// ? Marks the object as a session. Its scope is a session (init, destroy, timeout, invalid session)
// ? It must implement serializable
//@SessionScope
// ? It is very similar to the singleton, it's a singleton is stored in the servlet context
// ? (not in the app spring context)
//@ApplicationScope
public class Invoice implements Serializable {
  @Value("${invoice.description}")
  private String description;
  @Autowired
  private Client client;
  @Autowired
  @Qualifier("invoiceOfficeItem")
  private List<InvoiceItem> items;

  // !Life cycle
  @PostConstruct
  // !It is executed after object creation and injection dependencies
  public void init() {
    client.setName(client.getName() + " Post Construct");
    description = description.concat(" ").concat(client.getName());
  }

  // !It is executed before of object destroying
  @PreDestroy
  public void destroy() {
    System.out.println("Invoice destroyed: ".concat(description));
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<InvoiceItem> getItems() {
    return items;
  }

  public void setItems(List<InvoiceItem> items) {
    this.items = items;
  }
}
