package com.santihs.web.app.controllers;

import com.santihs.web.app.models.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
  @Autowired
  private Invoice invoice;

  @GetMapping("/see")
  public String getInvoice(Model model) {
    model.addAttribute("title", "This is a facture");
    model.addAttribute("invoice", invoice);
    return "invoice/see";
  }
}

