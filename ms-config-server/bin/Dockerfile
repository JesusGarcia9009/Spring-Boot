FROM adoptopenjdk/openjdk11:alpine-jre

#ANTES DE COMPIAR DEBE SER EJECUTADO EN EL RUNNER.
ARG JAR_FILE=target/pdr-config-server-1.0-SNAPSHOT.jar
WORKDIR /opt/app

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]