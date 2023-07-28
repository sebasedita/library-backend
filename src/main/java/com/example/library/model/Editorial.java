package com.example.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Editorial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String nombre;

  public String getNombre() {
    return this.nombre;
  }

  public String direccion;

  public String getDireccion() {
    return this.direccion;
  }

}