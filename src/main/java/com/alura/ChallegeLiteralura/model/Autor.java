package com.alura.ChallegeLiteralura.model;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birth_year;
    private Integer death_year;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false) // Relación con Libro
    private Libros libros; // Referencia al libro

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparación con la misma referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Tipo diferente
        Autor autor = (Autor) obj;
        return name.equals(autor.name); // Comparación solo por nombre
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // Hash basado solo en el nombre
    }


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libros getLibro() {
        return libros;
    }
    public Integer getBirth_year() {
        return birth_year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autor: ").append(name).append("\n")
                .append("fecha nacimiento: ").append(birth_year).append("\n")
                .append("fecha fallecimiento: ").append(death_year).append("\n")
                .append("------------------------------------------------");

        return sb.toString();
    }
}
