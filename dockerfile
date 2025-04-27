# Usa una imagen de OpenJDK 21
FROM openjdk:21-jdk-slim

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Establece el directorio de trabajo
WORKDIR /app

# Copia todo el código fuente a /app
COPY . /app

# Ejecuta Maven para compilar el proyecto
RUN mvn clean install

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Ejecuta el archivo JAR con Java
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
