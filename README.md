# poc-sof-delete-REST

## Introducción

Este repositorio es una API REST  sobre una POC de borrado lógico de productos. Existen dos clases de productos:
* Los productos con fecha de incio y fin
* Los productos con un estado con dos posibles valores (ACTIVE, DELETED).


## Ejecución 📦

Para la ejecución de este repositorio se debe tener un clon del mismo en local. Una vez se tiene el repositorio en local, estando en el directorio del repositorio, se ejecutan los siguiente comandos:

```
mvn clean install
mvn spring-boot_run
```

## Consumición API REST
### Listado de todos los productos con fecha vigente
Para poder obtener la lista de productos con fecha vigente en base de datos, se debe ejecutar un GET con la url:
```
http://localhost:8080/api/v1/products
```

### Borrado lógico de un producto vigente
Para poder borrar un producto de la base de datos con fecha vigente (borrado lógico), se debe ejecutar un DELETE con la url y un id de un producto vigente:
```
http://localhost:8080/api/v1/product/{id}   ## La id debe ser el número identificativo de un producto activo.
http://localhost:8080/api/v1/product/4
```

### Listado de todos los productos activos
Para poder obtener la lista de productos activos en base de datos, se debe ejecutar un GET con la url:
```
http://localhost:8080/api/v1/products-flag
```

### Borrado lógico de un producto activo
Para poder borrar un producto activo de la base de datos (borrado lógico), se debe ejecutar un DELETE con la url y un id de un producto activo:
```
http://localhost:8080/api/v1/product-flag/{id}   ## La id debe ser el número identificativo de un producto activo.
http://localhost:8080/api/v1/product-flag/5
```

## Construido con 🛠️
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring Tool 4](https://spring.io/tools) - Como IDE de desarrollo
