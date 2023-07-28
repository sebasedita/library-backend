package com.example.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Libro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String titulo;

  public String getTitulo() { 
    return this.titulo;
  }

  public String isbn;

  public String getIsbn() {
    return this.isbn;
  }

  @ManyToOne
  @JoinColumn(name = "autor_id")
public Autor autor;

  public Autor getAutor() {
    return this.autor;
  }

  @ManyToOne
  @JoinColumn(name = "editorial_id")
public Editorial editorial;

  public Editorial getEditorial() {
    return this.editorial; 
  }

}
