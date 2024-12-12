package com.alura.ChallegeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(  @JsonAlias("title") String titulo,
                           @JsonAlias("authors")String actores,
                           @JsonAlias("languages") String idioma,
                           @JsonAlias("download_count")Long descarga){
}
