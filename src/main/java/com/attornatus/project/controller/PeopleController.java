package com.attornatus.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.project.model.People;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

  @GetMapping
  public ResponseEntity<People> findAll() {
    People people = new People();
    return ResponseEntity.ok().body(people);
  }
}
