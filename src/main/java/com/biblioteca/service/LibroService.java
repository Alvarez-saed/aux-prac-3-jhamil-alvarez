package com.biblioteca.service;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository repositorio;

    public LibroService(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Libro crear(LibroDTO dto) {
        Libro nuevo = new Libro(
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getPublicationYear(),
                dto.getCategory(),
                dto.isAvailable()
        );
        return repositorio.save(nuevo);
    }

    public List<Libro> listarTodos() {
        return repositorio.findAll();
    }

    public Libro obtenerPorId(Long id) {
        return repositorio.findById(id)
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
        return repositorio.save(libro);
    }

    public void eliminar(Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Libro con ID " + id + " no encontrado");
        }
        repositorio.deleteById(id);
    }
}
