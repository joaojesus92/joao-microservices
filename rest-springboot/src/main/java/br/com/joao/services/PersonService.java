package br.com.joao.services;

import br.com.joao.model.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

  private final AtomicLong counter = new AtomicLong();

  public Person findById(String id) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("João Pedro");
    person.setLastName("Oliveira de Jesus");
    person.setAddress("Gama - DF - Brazil");
    person.setGender("Male");
    return person;
  }

  public List<Person> findAll() {
    List<Person> persons = new ArrayList<>();

    for (int i=0; i < 8; i++) {
      final Person person = mockPerson(i);
      persons.add(person);
    }
    return persons;
  }

  private Person mockPerson(int i) {
    final Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Person name: " + i);
    person.setLastName("Last Name: " + i);
    person.setAddress("Some address in Brazil: " + i);
    person.setGender(i % 2 == 0 ? "Male" : "Female");
    return person;
  }

  public Person create(Person person) {
    person.setId(counter.incrementAndGet());
    return person;
  }

  public Person update(Person person) {
    person.setId(counter.incrementAndGet());
    return person;
  }

  public void delete(String id) {
    return;
  }
}
