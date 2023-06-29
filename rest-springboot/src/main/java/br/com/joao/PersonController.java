package br.com.joao;

import br.com.joao.model.Person;
import br.com.joao.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService service;

  @GetMapping(value = "/{id}")
  public Person findById(@PathVariable("id") String id) {
    return service.findById(id);
  }

  @GetMapping
  public List<Person> findAll() {
    return service.findAll();
  }

  @PostMapping
  public ResponseEntity<Person> create(@RequestBody Person person) {
    return ResponseEntity.ok().body(service.create(person));
  }

  @PutMapping
  public ResponseEntity<Person> update(@RequestBody Person person) {
    return ResponseEntity.ok().body(service.update(person));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> delete(@PathVariable("id") String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}
