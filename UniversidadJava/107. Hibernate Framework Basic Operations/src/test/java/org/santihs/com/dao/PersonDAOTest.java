package org.santihs.com.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.santihs.com.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

  private PersonDAO personDAO;

  @BeforeEach
  void setUp() {
    personDAO = new PersonDAO();
  }

  @Test
  void personDAOCreation() {
    var persons = personDAO.list();
    assertNotNull(persons);
    assertFalse(persons.isEmpty());
  }

  @Disabled
  @Test
  void createAPersonInDB() {
    Person person = new Person("Sho", "Sanchez", false);
    personDAO.insert(person);
  }

  @Test
  void updateAPersonInDB() {
    Person person = new Person(22L, "Santi Update", "LastName", true);
    var result = personDAO.update(person);
    assertNotNull(result);
  }

  @Test
  void findANullPersonInDb() {
    Person person = new Person(12L, "Santi Update", "LastName", true);
    Person found = personDAO.findById(person.getCi());
    assertNull(found);
  }

  @Test
  void deletePersonInDataBase() {
    var person = personDAO.findById(22L);
    personDAO.delete(person);
    assertEquals(personDAO.list().size(), 1);
  }
}