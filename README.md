# LiterAlura 📚

**Descripción breve**:  
LiterAlura es una aplicación de consola desarrollada con Spring Boot para gestionar un catálogo de libros. Permite interactuar con los usuarios a través de varias opciones, como buscar libros por autor, título o género, y almacenar esta información en una base de datos PostgreSQL.

---

## Descripción 📖  
LiterAlura es una aplicación que tiene como objetivo facilitar la búsqueda y catalogación de libros mediante la interacción con la [API Gutendex](https://gutendex.com/), un catálogo con más de 70,000 libros disponibles en Project Gutenberg. Los usuarios pueden buscar libros y autores, ver los resultados filtrados y almacenarlos en una base de datos local para futuras consultas.

A través de la consola, los usuarios tienen acceso a varias opciones para explorar el catálogo, que se actualiza en tiempo real mediante solicitudes a la API de libros. Los datos obtenidos en formato JSON son procesados y almacenados, permitiendo una visualización más sencilla de los resultados.

### ¿Qué es la API Gutendex? 🤔  
La API Gutendex es una herramienta que permite acceder a un vasto catálogo de libros presentes en Project Gutenberg, una biblioteca en línea y gratuita que ofrece libros en formato electrónico. No es necesario obtener una clave de acceso para realizar consultas en la API; simplemente se pueden realizar peticiones siguiendo las instrucciones proporcionadas en la documentación.

**Enlace de la API**:  
- [Gutendex API](https://gutendex.com/)

**Repositorio oficial de la API**:  
- [GitHub - garethbjohnson/gutendex](https://github.com/garethbjohnson/gutendex)

---

## Características principales ✨  
- **Búsqueda de libros por autor, título o género**: Permite realizar búsquedas específicas para encontrar libros basados en estos criterios.
- **Interfaz de consola**: Los usuarios interactúan con el sistema directamente desde la consola, eligiendo entre diversas opciones.
- **Consumo de la API Gutendex**: La aplicación hace solicitudes a la API de Gutendex para obtener la información sobre los libros disponibles en Project Gutenberg.
- **Almacenamiento en base de datos PostgreSQL**: Los resultados obtenidos de la API se guardan en una base de datos local para facilitar futuras consultas.
- **Filtrado y visualización**: Los usuarios pueden filtrar y visualizar los libros y autores según su interés, de manera rápida y sencilla.

---

## Instalación y configuración ⚙️  

### Requisitos previos:
- **Java JDK**: Versión 17 o superior (recomendado: Java 17 LTS).
- **Maven**: Versión 4 o superior.
- **Spring**: Versión 3.2.3 o superior (disponible en Spring Initializr).
- **PostgreSQL**: Versión 16 o superior.
- **IDE (opcional)**: IntelliJ IDEA (recomendado para el desarrollo Java).
  - [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
  
### Configuración del proyecto en Spring Initializr:

Para crear el proyecto, usa el [Spring Initializr](https://start.spring.io/):

- **Java**: Versión 17 o superior.
- **Maven**: Versión 4 (la predeterminada).
- **Spring Boot**: Versión 3.2.3.
- **Tipo de proyecto**: JAR.
  
#### Dependencias a agregar:
- **Spring Data JPA**: Para la gestión de la base de datos.
- **PostgreSQL Driver**: Para conectarse a la base de datos PostgreSQL.

---

### Pasos para la instalación:

```bash
# Clonar el repositorio
git clone https://github.com/Paola05BE/LiterAlura.git

# Acceder al directorio del proyecto
cd LiterAlura

# Instalar dependencias (si es necesario)
mvn install
