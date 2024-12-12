package com.alura.ChallegeLiteralura.model;

public enum Lenguaje {
    ESPANOL("es", "Español"),
    INGLES("en", "Ingles"),
    FRANCES("fr", "Francés"),
    PORTUGUES("pt", "Portugués");

    private String lenguajeOmdb;
    private String lenguajeEspanol;
    Lenguaje (String lenguajeOmdb, String lenguajeEspanol) {
        this.lenguajeOmdb = lenguajeOmdb;
        this.lenguajeEspanol = lenguajeEspanol;
    }

    public static Lenguaje fromString(String text) {
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (lenguaje.lenguajeOmdb.equalsIgnoreCase(text)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);

    }

    public static Lenguaje fromEspanol(String text) {
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (lenguaje.lenguajeEspanol.equalsIgnoreCase(text)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);

    }
}
