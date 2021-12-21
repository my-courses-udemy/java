package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.Invoice;
import org.shuanacu.api.stream.examples.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ExampleStreamFlatMapInvoice {

    public static void main(String[] args) {
        User user1 = new User("Jhon", "Doe");
        User user2 = new User("Pepe", "Perez");

        user1.addInvoice(new Invoice("Shopping technology"));
        user1.addInvoice(new Invoice("Shopping table"));

        user2.addInvoice(new Invoice("Shopping bicycle"));
        user2.addInvoice(new Invoice("Shopping notebook"));

        List<User> users = Arrays.asList(user1, user2);
        users.stream()
                .map(User::getInvoices)
                .flatMap(List::stream)
//                .flatMap(u -> u.getInvoices().stream())
                .forEach(invoice -> System.out.println(invoice.getDescription()
                        .concat(", user: ")
                        .concat(invoice.getUser().toString())));

        /*for (User user : users) {
            for (Invoice invoice : user.getInvoices()) {
                System.out.println(invoice.getDescription());
            }
        }*/

    }

}
