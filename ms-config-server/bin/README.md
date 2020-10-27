# pdr-config-server

Config server es una aplicacion de springboot cloud orientado a centralizar los properties o configuracion de los microservicios.

## Comenzando 🚀

Descargar Fuentes de git

```
git clone http://srv-gitlab.pdr.local/grupo-sistema-cobranzas/back-end-cross/pdr-config-server.git
git checkout develop
```
Una vez descargada las fuentes de debe ejecutar en consola:

```
mvn clean install
```

Ademas de esto, se debe editar los archivo 'yml' donde se encuentran las configuraciones de conexion con el ConfigServer, su nombre debe ser:
> **bootstrap.yml**

En el cual se debe fijar la ruta de acceso al Config Server y el usuario de git y el nombre del archivo de propiedades.
 
## Agrupación
La estructura del proyecto es la siguiente

- com.pdr.session
- com.pdr.session.config
- com.pdr.session.controller
- com.pdr.session.controller.impl
- com.pdr.session.dto
- com.pdr.session.repository
- com.pdr.session.service
- com.pdr.session.service.impl
- com.pdr.session.utils

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


