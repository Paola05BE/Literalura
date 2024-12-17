package com.alura.ChallegeLiteralura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ConvierteDatos implements IconvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Método nuevo para deserializar listas
    public <T> List<T> obtenerListaDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, new TypeReference<List<T>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}