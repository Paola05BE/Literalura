package com.alura.ChallegeLiteralura.model;

import jakarta.persistence.*;
@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private  String actores;
    @Enumerated(EnumType.STRING)
    private Lenguaje idioma;
    private Long descarga;
    public Libros(){}

    public Libros(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.descarga = datosLibro.descarga();
        String textoIdioma = datosLibro.idioma();
        if (textoIdioma != null && !textoIdioma.isEmpty()) {
            this.idioma = Lenguaje.fromString(textoIdioma.trim());
        } else {
            // Puedes asignar un valor por defecto o dejarlo como null
            this.idioma = null;
            System.out.println("El campo de idioma está vacío o no tiene datos válidos.");
        }

        this.actores = datosLibro.actores();
    }
    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", totalDescargas=" + descarga +
                ", actores='" + actores + '\'' +
                ", idioma='" + idioma;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public Lenguaje getIdioma() {
        return idioma;
    }
    public void setIdioma(Lenguaje idioma) {
        this.idioma = idioma;
    }
    public Long getDescarga() {
        return descarga;
    }

    public void setDescarga(Long descarga) {
        this.descarga = descarga;
    }


}
