package com.attornatus.project.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.attornatus.project.model.People;
import com.attornatus.project.services.PeopleService;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

  @Autowired
  private PeopleService service;

  @GetMapping
  public ResponseEntity<List<People>> findAll() {
    List<People> peoples = service.findAll();
    return ResponseEntity.ok().body(peoples);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<People> findById(@PathVariable Long id) {
    People people = service.findById(id);
    if (people == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(people);
  }

  @PostMapping
  public ResponseEntity<People> add(@RequestBody People people) {
    try {
      People newPeople = service.add(people);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(newPeople.getId()).toUri();
      return ResponseEntity.created(uri).body(newPeople);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<People> update(@PathVariable Long id, @RequestBody People entity) {
    try {
      People peopleFind = service.findById(id);
      People people = service.update(id, entity);
      if (peopleFind == null) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok().body(people);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
