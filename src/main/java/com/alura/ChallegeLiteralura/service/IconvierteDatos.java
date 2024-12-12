package com.alura.ChallegeLiteralura.service;

public interface IconvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
