package com.attornatus.project.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /*
   * Não Descobrir como traduzir logradouro de uma boa forma. Então deixei em
   * português
   */

  private String logradouro;
  @NotNull(message = "O CEP não pode ser vazio.")
  @NotBlank(message = "O CEP não pode ser vazio.")
  @Column(unique = true, length = 8)
  @Size(max = 8, min = 8, message = "O valor deve ser de 8 digitos.")
  private String cep;

  @NotNull(message = "O Número não pode ser vazio.")
  @NotBlank(message = "O Número não pode ser vazio.")
  private int number;

  @NotNull(message = "A Cidade não pode ser vazia.")
  @NotBlank(message = "A Cidade não pode ser vazia.")
  private String city;

  @NotNull(message = "O Endereço Principal não pode ser vazia.")
  @NotBlank(message = "O Endereço Principal não pode ser vazia.")
  private boolean mainAddress = false;

  @ManyToOne
  @JoinColumn(name = "people_id")
  private People people;

  public Address() {
  }

  public Address(Long id, String logradouro, String cep, int number, String city, boolean mainAddress, People people) {
    this.id = id;
    this.logradouro = logradouro;
    this.cep = cep;
    this.number = number;
    this.city = city;
    this.mainAddress = mainAddress;
    this.people = people;
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

  public boolean isMainAddress() {
    return mainAddress;
  }

  public void setMainAddress(boolean mainAddress) {
    this.mainAddress = mainAddress;
  }

  public People getPeople() {
    return people;
  }

  public void setPeople(People people) {
    this.people = people;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    return true;
  }

}
