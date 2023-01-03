package com.attornatus.project.services;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.project.model.Address;
import com.attornatus.project.model.People;
import com.attornatus.project.repositories.AddressRepository;
import com.attornatus.project.repositories.PeopleRepository;
import java.util.Collections;

@Service
public class PeopleService {

  @Autowired
  private PeopleRepository repository;
  @Autowired
  private AddressRepository addressRepository;

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

  public Set<Address> findAllAddress(Long id) {
    People people = repository.findById(id).orElse(null);
    if (people == null) {
      return Collections.emptySet();
    }
    return people.getAddresses();
  }

  public Address addAddress(Long id, Address address) {
    People people = repository.findById(id).orElse(null);
    if (people == null) {
      return null;
    }
    address.setPeople(people);
    return addressRepository.save(address);
  }

  public Address setMainAddress(Long id, Long idAddress) {
    People people = repository.findById(id).orElse(null);
    if (people == null) {
      return null;
    }

    Set<Address> addresses = people.getAddresses();
    addresses.stream().forEach(e -> {
      if (e.getId().equals(idAddress)) {
        if (!e.isMainAddress()) {
          e.setMainAddress(true);
          addressRepository.save(e);
        } else {
          e.setMainAddress(false);
          addressRepository.save(e);
        }
      }
    });
    return addressRepository.findById(idAddress).orElse(null);
  }

  public Address getAddressMain(Long id) {
    People people = repository.findById(id).orElse(null);
    if (people == null) {
      return null;
    }
    return people.getAddresses().stream().filter(Address::isMainAddress).findFirst().orElse(null);
  }
}
