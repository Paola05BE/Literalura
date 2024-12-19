package com.alura.ChallegeLiteralura.repository;

import com.alura.ChallegeLiteralura.model.Autor;
import com.alura.ChallegeLiteralura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libros,Long> {
    Optional<Libros> findByTituloContainsIgnoreCase(String nombreLibro);

    boolean existsByTitulo(String titulo);

    @Query("SELECT a FROM Autor a")
    List<Autor> findAllAutores();
    @Query("SELECT l FROM Libros l JOIN l.autores a WHERE a IS NOT NULL")
    List<Libros> findLibrosConAutores(); // Método que devuelve libros junto con autores
    @Query("SELECT l FROM Libros l JOIN l.autores a WHERE a.birth_year <= :year AND" +
            " (a.death_year IS NULL OR a.death_year >= :year)")
    List<Libros> findLibrosConAutoresVivos(@Param("year") int year); // Método que devuelve libros con autores vivos en un año dado
    @Query("SELECT l FROM Libros l JOIN l.idioma i WHERE i = :idioma")//Método que devuelve libros de acuerdo con el indioma indicado
    List<Libros> findLibrosPorIdioma(@Param("idioma") String idioma);
}

