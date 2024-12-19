# LiterAlura 📚

## Descripción  
**LiterAlura** es una aplicación de consola creada con **Java** y **Spring Boot** para la lógica del backend. Utiliza **PostgreSQL** para almacenar los datos y **PgAdmin** para gestionarlos. Esta aplicación permite a los usuarios gestionar un catálogo de libros, consultar información de autores y realizar búsquedas filtradas por idioma, título y año.  

Los datos sobre libros y autores son obtenidos del servicio [Gutendex](https://gutendex.com/), una API que expone información basada en los libros disponibles en el Proyecto Gutenberg.  

---

## Integración con Gutendex 🌐  

**Gutendex** es un servicio que permite acceder a listas y detalles de libros con varios parámetros de búsqueda como título, idioma, años de vida del autor, temas, y más.  

---

## Características ✨

- **Buscar libros**:
  - Por título.
  - Por idioma.
  
- **Gestionar autores**:
  - Ver todos los autores registrados.
  - Consultar qué autores estaban vivos en un año específico.
  
- **Consumo de datos externos**:
  - Datos obtenidos del servicio [GutenDex](https://gutendex.com/).
  - Información guardada en la base de datos para acceso rápido y persistente.

---

## Tecnologías utilizadas 🚀

- **Java**: Para la lógica de negocio.
- **Spring Boot**: Framework para la construcción de la aplicación.
- **PostgreSQL**: Base de datos relacional.
- **PgAdmin**: Herramienta para la gestión de la base de datos.

---

## Menú principal 🌐

Al iniciar la aplicación, verás las siguientes opciones en la consola:
- **1 - Buscar libro por título**
- **2 - Listar libros registrados** 
- **3 - Listar autores registrados**
- **4 - Listar autores vivos en un determinado año**
- **5 - Listar libros por idioma** 
- **0 - Salir**  

---

## Instalación 🔧

### Requisitos previos:

- **Java JDK**: Versión 17 o superior.
- **Maven**: Para la gestión de dependencias.
- **PostgreSQL**: Para la base de datos.
- **PgAdmin**: Para administrar PostgreSQL.
- **IDE (opcional)**: IntelliJ IDEA o cualquier editor de tu preferencia.

### Instrucciones de instalación:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Paola05BE/LiterAlura.git
   cd LiterAlura
2. Crea una base de datos llamada liter_alura.
   Configura las credenciales en el archivo application.properties o application.yml

3. mvn install
  mvn spring-boot:run

4. java -jar target/LiterAlura.jar
 

### ¡Gracias por usar LiterAlura! 📚