package org.santihs.com;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.santihs.com.model.Person;

import java.util.List;

import static jakarta.persistence.Persistence.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    String hql = "SELECT p FROM Person p";

    EntityManagerFactory factory = createEntityManagerFactory("HibernateFramework");
    EntityManager entityManager = factory.createEntityManager();

    Query query = entityManager.createQuery(hql);
    List<Person> people = query.getResultList();
    System.out.println(people);
  }
}