package com.attornatus.project.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /* Não Descobrir como traduzir logradouro de uma boa forma */
  private String logradouro;
  private String cep;
  private int number;
  private String city;

  public Address() {
  }

  public Address(Long id, String logradouro, String cep, int number, String city) {
    this.id = id;
    this.logradouro = logradouro;
    this.cep = cep;
    this.number = number;
    this.city = city;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
    result = prime * result + ((cep == null) ? 0 : cep.hashCode());
    result = prime * result + number;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Address other = (Address) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (logradouro == null) {
      if (other.logradouro != null)
        return false;
    } else if (!logradouro.equals(other.logradouro))
      return false;
    if (cep == null) {
      if (other.cep != null)
        return false;
    } else if (!cep.equals(other.cep))
      return false;
    if (number != other.number)
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    return true;
  }

}
