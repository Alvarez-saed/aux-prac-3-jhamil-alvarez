package com.biblioteca.controller;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Libros", description = "Gestión de libros de la biblioteca")
public class LibroController {

    private final LibroService servicio;

    public LibroController(LibroService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo libro")
    public ResponseEntity<Libro> crear(@Valid @RequestBody LibroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los libros")
    public List<Libro> listar() {
        return servicio.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un libro por su ID")
    public Libro obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar información de un libro")
    public Libro actualizar(@PathVariable Long id, @Valid @RequestBody LibroDTO dto) {
        return servicio.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un libro")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}