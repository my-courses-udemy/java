package com.santihs.web.app;

import com.santihs.web.app.models.domain.InvoiceItem;
import com.santihs.web.app.models.domain.Product;
import com.santihs.web.app.models.services.IService;
import com.santihs.web.app.models.services.MyServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {
  // !Methods create the components, and return their instance
  @Bean("MyBeanService")
//  @Primary
  public IService myBeanService() {
    return new MyServiceBean();
  }

  @Bean("invoiceItem")
  public List<InvoiceItem> registerItems() {
    Product product1 = new Product(200, "Sony Camera");
    Product product2 = new Product(100, "Bike");
    return List.of(
            new InvoiceItem(product1, 3),
            new InvoiceItem(product2, 4)
    );
  }

  @Bean("invoiceOfficeItem")
  public List<InvoiceItem> registerOfficeItems() {
    Product product1 = new Product(200, "Sony Camera");
    Product product2 = new Product(100, "Bike");
    Product product3 = new Product(250, "TV LG");
    Product product4 = new Product(500, "Asus keyboard");
    Product product5 = new Product(1000, "Printer HP");
    return List.of(
            new InvoiceItem(product1, 3),
            new InvoiceItem(product2, 5),
            new InvoiceItem(product3, 2),
            new InvoiceItem(product4, 7),
            new InvoiceItem(product5, 1)
    );
  }
}
