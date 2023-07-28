package com.example.library.repository;

import com.example.library.model.Préstamo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PréstamoRepository extends JpaRepository<Préstamo, Long> {
}
