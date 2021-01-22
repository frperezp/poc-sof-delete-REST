# poc-sof-delete-REST

## Introducción

Este repositorio es una API REST  sobre una POC de borrado lógico de productos. Existen dos clases de productos:
* Los productos con fecha de incio y fin
* Los productos con un estado con dos posibles valores (ACTIVE, DELETED).

## Prerequisitos  📋
Los test de integracióne están desarrollados con Potman y se ejecutan automáticamente usando newman. Newman necesita para ejecutarse NodeJS. Por tanto se necesita tener instalado NodeJS
* [NodeJS](https://nodejs.org/es/) - Entorno en tiempo de ejecución multiplataforma
* [Newman](https://www.npmjs.com/package/newman) - Para la ejecución de los test de integración de Postman


## Ejecución 📦

Para la ejecución de este repositorio se debe tener un clon del mismo en local. Una vez se tiene el repositorio en local, estando en el directorio del repositorio, se ejecutan los siguiente comandos en una cmd:

```
mvn clean install
mvn spring-boot_run
```
## Test de integración 📦

Para la ejecución de los test de integración se necesitan 2 terminales (cmd). En la primera terminal, estando en el directorio del repositorio, ejecutaremos el comando:
```
mvn spring-boot:run
```
En la segunda terminal, estando en el directorio del repositorio, ejecutaremos el comando:
```
mvn verify -P postmanset
```

## Consumición API REST
### Consumición de Products
#### Listado de todos los productos con fecha vigente
Para poder obtener la lista de productos con fecha vigente en base de datos, se debe ejecutar un GET con la url:
```
(GET) http://localhost:8080/api/v1/products
```
#### Inserción de un producto con fechas
Para poder insertar en la base de datos se debe hacer un PUT con la siguiente url y un JSON en el body del request:
```
(PUT) http://localhost:8080/api/v1/product
```
Formato del JSON:
```
{
    "name": "iPhone 12 Pro",
    "fromInstant": "2020-11-17T16:47:52.690Z",
    "toInstant": "2024-09-13T16:47:52.690Z"
}
```
#### Actualización de un producto con fechas
Para poder insertar en la base de datos se debe hacer un POST con la siguiente url y un JSON en el body del request:
```
(POST) http://localhost:8080/api/v1/product
```
Formato del JSON:
```
{
    "id": "6",
    "name": "iPhone 13 Pro",
    "fromInstant": "2019-09-17T16:47:52.690Z",
    "toInstant": "2022-09-13T16:47:52.690Z"
}
```
⚠️ Si el producto de la actualización no está en base de datos (no existe ningún product con dicha ID), entonces se producirá una inserción.

#### Borrado lógico de un producto vigente
Para poder borrar un producto de la base de datos con fecha vigente (borrado lógico), se debe ejecutar un DELETE con la url y un id de un producto vigente:
```
(DELETE) http://localhost:8080/api/v1/product/{id}   ## La id debe ser el número identificativo de un producto activo.
(DELETE) http://localhost:8080/api/v1/product/4
```
### Consumición de ProductFlags
#### Listado de todos los productos activos
Para poder obtener la lista de productos activos en base de datos, se debe ejecutar un GET con la url:
```
(GET) http://localhost:8080/api/v1/product-flags
```
#### Inserción de un producto activo
Para poder insertar en la base de datos se debe hacer un PUT con la siguiente url y un JSON en el body del request:
```
(PUT) http://localhost:8080/api/v1/product-flag
```
Formato del JSON:
```
{
    "name": "iPhone 13 Pro",
    "state": "ACTIVE"
}
```

#### Actualización de un producto activo
Para poder insertar en la base de datos se debe hacer un POST con la siguiente url y un JSON en el body del request:
```
(POST) http://localhost:8080/api/v1/product-flag
```
Formato del JSON:
```
{
    "id": "6",
    "name": "iPhone 13R Pro",
    "state": "ACTIVE"
}
```
⚠️ Si el producto de la actualización no está en base de datos (no existe ningún productFlag con dicha ID), entonces se producirá una inserción.

#### Borrado lógico de un producto activo
Para poder borrar un producto activo de la base de datos (borrado lógico), se debe ejecutar un DELETE con la url y un id de un producto activo:
```
(DELETE) http://localhost:8080/api/v1/product-flag/{id}   ## La id debe ser el número identificativo de un producto activo.
(DELETE) http://localhost:8080/api/v1/product-flag/5
```

## Construido con 🛠️
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring Tool 4](https://spring.io/tools) - Como IDE de desarrollo
* [JAVA 8](https://openjdk.java.net/projects/jdk8/) - Versión de JAVA
