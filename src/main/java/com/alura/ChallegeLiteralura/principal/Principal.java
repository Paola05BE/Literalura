package com.alura.ChallegeLiteralura.principal;

import com.alura.ChallegeLiteralura.model.Autor;
import com.alura.ChallegeLiteralura.model.DatosLibro;
import com.alura.ChallegeLiteralura.model.Libros;
import com.alura.ChallegeLiteralura.repository.LibroRepository;
import com.alura.ChallegeLiteralura.service.ApiResponse;
import com.alura.ChallegeLiteralura.service.ConsumoAPI;
import com.alura.ChallegeLiteralura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BUSQUEDA = "?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;
    private List<Autor> autor;
    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }
    public void muestraElMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1; // Inicializar en un valor que no está en el rango 0-5

        while (opcion != 0) {
            // Mostrar menú
            var menu = """
                    Elija la opción a través de su número: 
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar actores registrados
                    4 - Listar actores vivos en un determinado año
                    5 - Listar libros por idioma             
                    0 - Salir
                    """;
            System.out.println(menu);

            try {
                opcion = teclado.nextInt(); // Intentar leer un entero

                // Validar rango
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Por favor, introduzca un número entre 0 y 5.");
                    continue; // Sigue en el bucle sin procesar la opción
                }

                // Procesar la opción seleccionada
                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: por favor ingrese un número.");
                teclado.nextLine(); // Limpiar el escáner para evitar un bucle infinito
            }
        }
        teclado.close(); // Cerrar el escáner al finalizar
    }

    private String construirUrlBusqueda(String nombreLibro) {
        try {
            // Codificar el nombre del libro para URL
            String nombreCodificado = URLEncoder.encode(nombreLibro, "UTF-8");
            return URL_BASE + URL_BUSQUEDA + nombreCodificado;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error al codificar el nombre del libro", e);
        }
    }
    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar:");
        String nombreLibro = teclado.nextLine().trim();

        // Validar que el nombre del libro no esté vacío
        if (nombreLibro.isEmpty()) {
            System.out.println("El nombre del libro no puede estar vacío. Intenta de nuevo.");
            return null;
        }
        String url = construirUrlBusqueda(nombreLibro);
        try {
            // Obtener datos de la API
            var json = consumoApi.obtenerDatos(url);

            // Deserializamos a ApiResponse para obtener resultados
            ApiResponse respuesta = conversor.obtenerDatos(json, ApiResponse.class);

            // Verificar si hay resultados
            if (respuesta != null && respuesta.getResults() != null && !respuesta.getResults().isEmpty()) {
                // Obtener solo el primer resultado
                DatosLibro datos = respuesta.getResults().get(0);
                return datos; // Retornar el objeto DatosLibro
            } else {
                return null; // Retorna null si no hay resultados
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener los datos: " + e.getMessage());
            e.printStackTrace(); // Por mejor práctica, imprimir más información.
            return null; // Manejar errores de conexión o deserialización
        }
    }
    private void buscarLibroPorTitulo() {
        DatosLibro datos = getDatosLibro(); // Obtiene los datos del libro
        if (datos == null){
            System.out.println("No es posible encontrar resultados para el libro indicado");
            return;
        }
        Libros libro = new Libros(datos.titulo(), datos.descarga(), datos.idiomas());
        List<Autor> autores = new ArrayList<>();
        Autor nuevoAutor = new Autor();

        if (datos != null) {
            if (repositorio.existsByTitulo(datos.titulo())) {
                System.out.println("El libro ya existe en la base de datos: " + datos.titulo());
                return; // Salir sin guardar el libro
            }
            // Listar autores y establecer su relación
            for (Autor autor : datos.autores()) {

                nuevoAutor.setName(autor.getName());
                nuevoAutor.setBirth_year(autor.getBirth_year());
                nuevoAutor.setDeath_year(autor.getDeath_year());
                nuevoAutor.setLibros(libro);
                autores.add(nuevoAutor); // Agrega el nuevo autor a la lista
            }

            libro.setAutores(autores);// Asocia la lista de autores al libro
            libro.setTitulo(datos.titulo());
            libro.setDescarga(datos.descarga());
            libro.setIdioma(datos.idiomas());
            // Guardar libro en el repositorio; JPA se ocupará de guardar también los autores
            repositorio.save(libro);
            System.out.println(libro);
        } else {
                System.out.println("No se pudo obtener datos del libro.");
        }
    }
    private void listarLibrosRegistrados() {
        List<Libros> librosGuardados = repositorio.findAll(); // Obtiene todos los libros guardados
        // Ordenar y mostrar cada libro
        librosGuardados.stream()
                .sorted(Comparator.comparing(Libros::getTitulo)) // Ordenar por título
                .forEach(libro -> System.out.println(libro)); // Imprimir usando el método toString()
    }
    private void listarAutoresRegistrados() {
        List<Libros> librosGuardados = repositorio.findLibrosConAutores(); // Obtener todos los libros con sus autores

        // Verifica si hay libros en la lista
        if (librosGuardados.isEmpty()) {
            System.out.println("No se encontraron libros registrados.");
        } else {
            // Usar un Map para almacenar autores y sus respectivos títulos de libros
            Map<Autor, Set<String>> autoresConLibrosMap = new HashMap<>();

            // Rellenar el mapa con datos de libros y autores
            librosGuardados.forEach(libro -> {
                if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
                    libro.getAutores().forEach(autor -> {
                        // Obtener el conjunto de títulos para este autor, inicializar si no existe
                        Set<String> librosPorAutor = autoresConLibrosMap.computeIfAbsent(autor, k -> new HashSet<>());
                        // Agregar el título del libro al conjunto del autor (Set evita títulos repetidos)
                        librosPorAutor.add(libro.getTitulo());
                    });
                }
            });

            // Imprimir los datos de cada autor una vez
            autoresConLibrosMap.forEach((autor, titulos) -> {
                // Imprimir la información del autor
                System.out.println("------------------------------------");
                System.out.println("Autor: " + autor.getName());
                System.out.println("Nacimiento: " + autor.getBirth_year());
                System.out.println("Fallecimiento: " + autor.getDeath_year());
                // Imprimir todos los libros del autor en una sola línea usando join
                System.out.println("Libros: " + String.join(", ", titulos));
            });
            System.out.println("------------------------------------");
        }
    }
    private void listarAutoresVivos() {
        System.out.println("Indica el año en el que deseas buscar el autor");

    }
    private void listarLibrosPorIdioma() {
    }
}
