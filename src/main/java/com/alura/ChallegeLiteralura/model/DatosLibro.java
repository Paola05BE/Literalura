package com.alura.ChallegeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro

        (@JsonAlias("title") String titulo,  // Mapeo desde JSON
         @JsonAlias("authors") List<Autor> autores, // Lista de autores
         @JsonAlias("languages") List<String> idiomas, // Lista de idiomas
         @JsonAlias("download_count") long descarga
        ) // Número de descargas
{
}
