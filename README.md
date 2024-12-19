# LiterAlura 📚

## Descripción  
**LiterAlura** es una aplicación de consola creada con **Java** y **Spring Boot** para la lógica del backend. Utiliza **PostgreSQL** para almacenar los datos y **PgAdmin** para gestionarlos. La interfaz de usuario está construida con **Bootstrap**, lo que facilitará su futura adaptación a la web. Con LiterAlura, los usuarios pueden gestionar un catálogo de libros, consultar información de autores y realizar búsquedas filtradas por idioma, título y año.

---

## Características ✨

- **Buscar libros**:
  - Por título.
  - Por idioma.
  
- **Gestionar autores**:
  - Ver todos los autores registrados.
  - Consultar qué autores estaban vivos en un año específico.
  
- **Persistencia de datos**:
  - Base de datos **PostgreSQL** para guardar y consultar la información.
  - **PgAdmin** para gestionar la base de datos.
  
- **Interfaz adaptable**:
  - Interfaz inicial basada en consola.
  - Adaptación futura para interfaz web utilizando **Bootstrap**.

---

## Tecnologías utilizadas 🚀

- **Java**: Para la lógica de negocio.
- **Spring Boot**: Framework para la construcción de la aplicación.
- **PostgreSQL**: Base de datos relacional.
- **PgAdmin**: Herramienta para la gestión de la base de datos.
- **Bootstrap**: Framework para la futura interfaz web.

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