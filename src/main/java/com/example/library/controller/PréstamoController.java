package com.example.library.controller;

import com.example.library.model.Préstamo;
import com.example.library.repository.PréstamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PréstamoController {

  @Autowired
  private PréstamoRepository préstamoRepository;

  @GetMapping
  public List<Préstamo> getAllPréstamos() {
    return préstamoRepository.findAll(); 
  }

  @PostMapping("/nuevo")
  public Préstamo createPréstamo(@Valid @RequestBody Préstamo préstamo) {
    return préstamoRepository.save(préstamo);
  }

  @GetMapping("/{id}")
  public Préstamo getPréstamoById(@PathVariable Long id){
    return préstamoRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
  }

  @PutMapping("/actualizar/{id}")
  public Préstamo actualizarPréstamo(@PathVariable Long id, @RequestBody Préstamo préstamo){
    
    Préstamo existePréstamo = préstamoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

    existePréstamo.setFechaDevolucion(préstamo.getFechaDevolucion());
    
    return préstamoRepository.save(existePréstamo);
  }

  @DeleteMapping("/{id}")
  public void deletePréstamo(@PathVariable Long id){
    préstamoRepository.deleteById(id);
  }

}
