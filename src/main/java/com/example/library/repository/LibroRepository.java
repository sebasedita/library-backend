package com.example.library.repository;

import com.example.library.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LibroRepository extends JpaRepository<Libro, Long> {
}

