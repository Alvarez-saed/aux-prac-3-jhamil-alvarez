package com.biblioteca.service;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


// Aquí manejo toda la logica de: guardar, buscar, modificar y borrar
@Service
public class LibroService {

    // Esta es la lista temporal en la memoria, sin base de datos
    private final List<Libro> libros = new ArrayList<>();
    // Esto servira para generar ID automaticos
    private final AtomicLong contador = new AtomicLong(1);

    public Libro crear(LibroDTO dto) {
        Libro nuevo = new Libro(
                contador.getAndIncrement(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getPublicationYear(),
                dto.getCategory(),
                dto.isAvailable()
        );
        libros.add(nuevo);
        return nuevo;
    }

    public List<Libro> listarTodos() {
        return new ArrayList<>(libros);
    }

    public Libro obtenerPorId(Long id) {
        return libros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Libro con ID " + id + " no encontrado"));
    }

    public Libro actualizar(Long id, LibroDTO dto) {
        Libro libro = obtenerPorId(id);
        libro.setTitle(dto.getTitle());
        libro.setAuthor(dto.getAuthor());
        libro.setIsbn(dto.getIsbn());
        libro.setPublicationYear(dto.getPublicationYear());
        libro.setCategory(dto.getCategory());
        libro.setAvailable(dto.isAvailable());
        return libro;
    }

    public void eliminar(Long id) {
        Libro libro = obtenerPorId(id);
        libros.remove(libro);
    }
}