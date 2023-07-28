package com.example.library.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Préstamo;
import com.example.library.repository.PréstamoRepository;

@Service
public class PréstamoService {

  @Autowired
  private PréstamoRepository préstamoRepository;
  
  public Préstamo crear(Préstamo préstamo){
    préstamo.setFechaPrestamo(LocalDate.now());
    calcularFechaDevolución(préstamo);
    return préstamoRepository.save(préstamo);
  }

  private void calcularFechaDevolución(Préstamo préstamo){
    // Lógica para calcular fecha y asignar a préstamo.fechaDevolución 
  }

}

