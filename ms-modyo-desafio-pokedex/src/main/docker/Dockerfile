# Build interno maven
FROM maven:3.6.3-openjdk-8 AS mvn-compile
WORKDIR /maven
COPY .  .
RUN mvn -f ./pom.xml clean package -DskipTests=true

#Imagen opensource JDK 8 (Se alojan en repo google)
FROM gcr.io/google-appengine/openjdk:8
#Variable de entorno de juego de caracteres basado en el proyecto
ENV LANG C.UTF-8
#TimeZone
ENV TZ="America/Santiago"
#Agrega el JAR generado del microservicio
COPY --from=mvn-compile /maven/target/*.jar /api/app.jar
RUN ls /api
WORKDIR /api
ENTRYPOINT exec java -jar app.jar

# docker build -t test:lts -f ./src/main/docker/Dockerfile .
# docker run -d test:lts
