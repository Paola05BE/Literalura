package com.alura.ChallegeLiteralura.model;

import com.alura.ChallegeLiteralura.model.Autor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id")) // Configura la tabla para la colección
    @Column(name = "idioma") // Nombre de la columna que almacenará cada idioma
    private List<String> idioma; // Idiomas del libro
    private long descarga;  // Número de descargas

    @OneToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
    public Libros(){}

    public Libros(DatosLibro datos) {
        this.titulo = datos.titulo();
        this.descarga = datos.descarga();
        this.idioma = datos.idiomas();
    }

    public Libros(String titulo, long descarga, List<String> idiomas) {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public long getDescarga() {
        return descarga;
    }

    public void setDescarga(long descarga) {
        this.descarga = descarga;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------LIBRO---------------------------\n");
        sb.append("Título: ").append(titulo).append("\n");
        // Información sobre los autores:
        if (autores != null && !autores.isEmpty()) {
            sb.append("Autor: ");
            for (Autor autor : autores) {
                sb.append("").append(autor.getName()).append("\n");
            }
        } else {
            sb.append("Autor: No disponible\n");
        }
        sb.append("Idioma: ").append(idioma != null ? String.join(", ", idioma)
                : "No especificado").append("\n");
        sb.append("Número de Descargas: ").append(descarga).append("\n");
        return sb.toString();
    }
}
