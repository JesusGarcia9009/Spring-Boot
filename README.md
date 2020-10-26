# Entorno Java Arquitectura de Microservicios con Spring Boot

Entorno completo de Microservicios JAVA utilizando Springboot + SpringCloudConfig + GitLab + Docker + Kubernetes

## Pre-requisitos 🛠

- Maquina Virtual de Java
- Maven
- Variables de entorno
- Docker 
- IDE
- Lombok
- git
- docker 
- docker-compose
- minikube (kubectl + k8s)

## Comenzando 🚀

Descargar Fuentes de git

```
git clone https://github.com/JesusGarcia9009/Spring-Boot.git
```
Una vez descargada las fuentes de debe ejecutar en consola se debe definir ruta para la carga de los properties en gitlab o git hub: 

Luego de esto, se debe editar los archivo 'yml' donde se encuentran las configuraciones de conexion con el 'ms-config-server', su nombre debe ser:
> **bootstrap.yml**

En el cual se debe fijar la ruta de acceso al Config Server y el usuario de git y el nombre del archivo de propiedades.
 
## Sicronizar MSs
Editar los archivo 'yml' donde se encuentran la carpeta resources de cada ms 'ms-cliente y ms-session' configurar puerto del gestor de configuraciones Config Server

### Instalación 🔧

Para la instalacion de cada MSs por separado solo se debe ejecutar el siguiente comando
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




