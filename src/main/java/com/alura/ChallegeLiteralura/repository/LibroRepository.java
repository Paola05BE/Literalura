package com.alura.ChallegeLiteralura.repository;

import com.alura.ChallegeLiteralura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libros,Long> {
    Optional<Libros> findByTituloContainsIgnoreCase(String nombreLibro);
}
