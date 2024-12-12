package com.alura.ChallegeLiteralura.principal;

import com.alura.ChallegeLiteralura.model.DatosLibro;
import com.alura.ChallegeLiteralura.model.Libros;
import com.alura.ChallegeLiteralura.repository.LibroRepository;
import com.alura.ChallegeLiteralura.service.ConsumoAPI;
import com.alura.ChallegeLiteralura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BUSQUEDA = "?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();

    private LibroRepository repositorio;
    private Optional<Libros> libroBuscado;

    public Principal(LibroRepository repository)  {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija  la opción a través de su número: 
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar actores registrados
                    4 - Listar actores vivos en un determinado año
                    5 - listar libros por idioma             
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarActoresRegistrados();
                    break;
                case 4:
                    listarActoresVivos();
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
        }

    }
    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+URL_BUSQUEDA + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        System.out.println(datos);
        return datos;
    }
    private void buscarLibroPorTitulo() {
        getDatosLibro();
    }
    private void listarActoresRegistrados() {
    }

    private void listarLibrosRegistrados() {
    }

    private void listarActoresVivos() {
    }

    private void listarLibrosPorIdioma() {
    }
}
