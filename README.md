# Práctica 2 - Jhamil Alvarez

API REST desarrollada con Spring Boot para la gestion de libros de una biblioteca, 
este es mi trabajo de la segunda practica
Hice una API para gestionar libros de una biblioteca, todo funciona con una lista en memoria, no necesita instalar nada mas.
## Funcionalidad
Los datos se almacenan en memoria sin base de datos

## Endpoints

**POST**   `/api/books`          → Agregar libros
**GET**    `/api/books`          → Ver todos los libros
**GET**    `/api/books/{id}`     → Buscar por ID
**PUT**    `/api/books/{id}`     → Actualizar libros
**DELETE** `/api/books/{id}`     → Eliminar libros

## Swagger
http://localhost:8081/swagger-ui.html
## Ejecución
Ejecutar la aplicación desde el IDE
Acceder a Swagger para probar los endpoints