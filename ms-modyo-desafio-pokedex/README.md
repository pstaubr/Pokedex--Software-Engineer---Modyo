# Microservicio ms-modyo-desafio-pokedex

1. [Propiedad](/readme.md#1-propiedad)
2. [Operaciones](/readme.md#2-operaciones)
3. [Especificación Técnica](/readme.md#3-especificaci%C3%B3n-t%C3%A9cnica)
4. [Dependencias](/readme.md#4-ejecuci%C3%B3n)

## 1. Propiedad

Esta sección detalla quién es el responsable del ciclo de vida del microservicio.

### 1.1. Dueño del negocio

Unidad de negocio responsable y desarrollador del microservicio.

- Persona que desarrollo el desafío modyo:
    - Desarrollador: Pablo Staub
    - Contacto:  Celular +56966495190 / pablo.staubr@gmail.com

## 2. Operaciones

Detalla las operaciones que se pueden exponer a través del microservicio.

| Operación | Descripción Capacidad |
| --------- | --------------------- | 
| [POST] /modyo-poke-dex/v1/pokedex/{name}| Permite consultar informacion basica, tipo , peso, listado de habilidades, descripción y evoluciones de un pokemon por id o name
| [GET] /modyo-poke-dex/v1/liveness| Test de conectividad con el microservicio|

## 3. Especificación Técnica

Detalle técnico del microservicio:
-Realiza peticiones consumiendo el ldap de coas

Detalle técnico del microservicio provisto por especificación Swagger. | Ambiente | Descripción|
|----------|------------| | [Desa]   | /swagger-ui.html| | [QA]     | /swagger-ui.html|

Nota: en producción se debe deshabilitar el Swagger

## 4. Dependencias

Detalla los sistemas y otros microservicios que son necesarios para el funcionamiento de este microservicio.

### 4.1. Microservicios

No aplica.

### 4.2. Repositorio de Datos

No aplica.

### 4.3. Backends

LDAP COAS

### 5.1. Configuraciones

Detalla las configuraciones necesarias para que el microservicio pueda operar:

#### 5.1.1. Secretos

No aplica.

### 5.2. Ejecución

#### 5.2.1. Recursos Utilizados

Detalla los recursos utilizados por una instancia de un contenedor docker.

| Recurso | Requerido |
| ------ | ------ |
| CPU | Detallar cuánto recurso de CPU se debería destinar a una instancia de microsevicio |
| Memoria | Detallar cuánto recurso de Memoria se debería destinar a una instancia de microsevicio |
| Storage | Detallar cuánto almacenamiento se debería reservar para una instancia de microsevicio |
| Throughput| Detallar cuántos usuarios concurrentes permiten la especificación de recursos descrita anteriormente |