package org.santihs.com.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.santihs.com.model.Person;

import java.util.List;

public class PersonDAO {
  private EntityManagerFactory factory;
  private EntityManager manager;

  public PersonDAO() {
    this.factory = Persistence.createEntityManagerFactory("HibernateFrameworkPU");
    this.manager = factory.createEntityManager();
  }

  public List<Person> list() {
    String hql = "SELECT p FROM Person p";
    Query query = manager.createQuery(hql);
    List<Person> people = query.getResultList();
    return people;
  }

  public void insert(Person person) {
    try {
      manager.getTransaction().begin();
      manager.persist(person);
      manager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      manager.getTransaction().rollback();
    } finally {
//      ?if (manager != null) {
//      ?  manager.close();
//      ?}
    }
  }

  public Person update(Person person) {
    Person result = null;
    try {
      manager.getTransaction().begin();
      result = manager.merge(person);
      manager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      manager.getTransaction().rollback();
    } finally {
//      ?if (manager != null) {
//      ?  manager.close();
//      ?}
    }
    return result;
  }

  public Person findById(long id) {
    return manager.find(Person.class, id);
  }

  public void delete(Person person) {
    try {
      manager.getTransaction().begin();
      manager.remove(person);
      manager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      manager.getTransaction().rollback();
    }
  }
}
