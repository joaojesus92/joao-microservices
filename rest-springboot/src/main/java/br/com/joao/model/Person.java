package br.com.joao.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  public Person() {}

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getGender() {
    return gender;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id.equals(person.id) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && address.equals(person.address) && gender.equals(person.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address, gender);
  }
}
