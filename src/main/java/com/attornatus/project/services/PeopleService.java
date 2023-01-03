package com.attornatus.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.project.model.People;
import com.attornatus.project.repositories.PeopleRepository;

@Service
public class PeopleService {

  @Autowired
  private PeopleRepository repository;

  public List<People> findAll() {
    return repository.findAll();
  }

  public People findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public People add(People people) {
    return repository.save(people);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public People update(Long id, People people) {
    people.setId(id);
    return repository.save(people);
  }
}
