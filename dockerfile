# Etapa de construcción
FROM maven:3.9.3-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiamos pom.xml y src para construir
COPY pom.xml .
COPY src ./src

# Compilamos sin tests
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado en target
COPY --from=builder /app/target/gestion-incidencias-ra3-prueba-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
