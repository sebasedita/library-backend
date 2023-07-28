package com.example.library.controller;

import com.example.library.model.Editorial;
import com.example.library.repository.EditorialRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    private final EditorialRepository editorialRepository;

    public EditorialController(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @GetMapping
    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }

    @PostMapping
    public Editorial createEditorial(@Valid @RequestBody Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @GetMapping("/{id}")
    public Editorial getEditorialById(@PathVariable Long id) {
        return editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
    }

    @PutMapping("/{id}")
    public Editorial updateEditorial(@PathVariable Long id, @Valid @RequestBody Editorial editorialDetails) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
        editorial.nombre = editorialDetails.getNombre();
        editorial.direccion = editorialDetails.getDireccion();
        return editorialRepository.save(editorial);
    }

    @DeleteMapping("/{id}")
    public void deleteEditorial(@PathVariable Long id) {
        editorialRepository.deleteById(id);
    }
}
