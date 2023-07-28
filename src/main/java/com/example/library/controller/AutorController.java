package com.example.library.controller;

import com.example.library.model.Autor;
import com.example.library.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

  private final AutorRepository autorRepository;

  public AutorController(AutorRepository autorRepository) {
    this.autorRepository = autorRepository;
  }

  @GetMapping
  public List<Autor> getAllAutores() {
    return autorRepository.findAll();
  }

  @PostMapping
  public Autor createAutor(@Valid @RequestBody Autor autor) {
    return autorRepository.save(autor);
  }

  @GetMapping("/{id}")
  public Autor getAutorById(@PathVariable Long id) {
    return autorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado")); 
  }

  @PutMapping("/{id}")
  public Autor updateAutor(@PathVariable Long id, @Valid @RequestBody Autor autorDetails) {
  
    Autor autor = autorRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
              
    // Solución: asignar directamente a los atributos  
    autor.nombre = autorDetails.getNombre(); 
    autor.nacionalidad = autorDetails.getNacionalidad();
    
    return autorRepository.save(autor);
  }

  @DeleteMapping("/{id}")
  public void deleteAutor(@PathVariable Long id) {
    autorRepository.deleteById(id);
  }

}
