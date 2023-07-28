package com.example.library.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Préstamo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id;

  private LocalDate fechaPrestamo;
  
  private LocalDate fechaDevolucion;

  public LocalDate getFechaPrestamo() {
    return fechaPrestamo;
  }

  public void setFechaPrestamo(LocalDate fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }
  
  public void setFechaDevolución(LocalDate fechaDevolucion) {
	    this.setFechaDevolucion(fechaDevolucion);
	  }

public LocalDate getFechaDevolucion() {
	return fechaDevolucion;
}

public void setFechaDevolucion(LocalDate fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
}

  //Getter y setter similar para fechaDevolucion

}
