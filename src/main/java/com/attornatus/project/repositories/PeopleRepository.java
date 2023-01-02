package com.attornatus.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.project.model.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
