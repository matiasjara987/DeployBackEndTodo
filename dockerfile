# Usa una imagen de OpenJDK
FROM openjdk:21-jre-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR a la carpeta de trabajo
COPY backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Ejecuta el archivo JAR con Java
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
