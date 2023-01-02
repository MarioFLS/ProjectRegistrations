package com.attornatus.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.project.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
