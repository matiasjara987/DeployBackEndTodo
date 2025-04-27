FROM openjdk:21-jre-slim 
WORKDIR /app
COPY . /app
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"] 
