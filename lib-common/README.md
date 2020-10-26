# pdr-lib-common

Libreria commun para todos los proyectos de cobranza, simplifica la codificacion y repeticion de codigo y regeneracion de entidades, ya que se encontrara compartida, tambien se incluyen clases utils

## Comenzando 🚀

Descargar Fuentes de git

```
git clone http://srv-gitlab.pdr.local/grupo-sistema-cobranzas/back-end-cross/pdr-lib-common.git
git checkout develop
```
Una vez descargada las fuentes de debe ejecutar en consola:

```
mvn clean install
```

## Agrupación
La estructura del proyecto es la siguiente

- com.pdr.common.cobranza.entity
- com.pdr.common.cobranza.repository
- com.pdr.common.cobranza.repository.sp.atcpar
- com.pdr.common.cobranza.repository.sp.atcpar.impl
- com.pdr.common.config
- com.pdr.common.dto
- com.pdr.common.dto.solp
- com.pdr.common.exception
- com.pdr.common.session.entity
- com.pdr.common.session.enums
- com.pdr.common.session.repository
- com.pdr.common.session.security
- com.pdr.common.session.security.annotations
- com.pdr.common.session.security.dto
- com.pdr.common.utils

## Pre-requisitos 🛠

- Maquina Virtual de Java
- Maven
- Variables de entorno
- Docker 
- IDE
- Lombok


### Instalación 🔧

Para la instalacion solo se debe ejecutar el siguiente comando
```
mvn clean install
```

## Ejecutando las pruebas ⚙

- No aplica 

## Despliegue 📦

```
$mvn clean install
$docker build -t registry.gitlab.com/bs2managers/{component}:{release}_{enviroment} .
$docker push registry.gitlab.com/bs2managers/{component}:{release}_{enviroment}
$kubectl apply -f k8s
```

## Construido con 🛠


Herramientas y lenguajes utilizados


* [Java](https://www.java.com/) - Lenguaje de programacion.
* [Maven](https://maven.apache.org/) - Manejador de dependencias.
* [Eclipse](https://www.eclipse.org/) - IDE de desarrollo.
* [DBeaver](https://dbeaver.io//) - Herramienta de base de datos.
* [Swagger](https://swagger.io/) - Documentacion de los servicios.
* [Lombok](https://projectlombok.org/) - Creacion de metodos basicos de objetos.


## Autores.

* **Jesús García** - *Trabajo Inicial-Programación-Dcumentación* 

* **Nelson Alvarado** - *Trabajo Inicial-Programación-Dcumentación* 

* **Fabian Rojas** - *Trabajo Inicial-Programación-Dcumentación* 

* **Sevastian Valenzuela** - *Trabajo Inicial-Programación-Dcumentación* 

* **Patricio Martinez** - *Trabajo Inicial-Programación-Dcumentación* 


## Agradecimientos


* Gracias a todos los participantes del proyecto, desde sus inicios hasta su fin.


