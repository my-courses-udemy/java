package org.shuanacu.api.stream.examples.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private List<Invoice> invoices;

    private static int lastId;


    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = ++lastId;
        this.invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        invoice.setUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

}
