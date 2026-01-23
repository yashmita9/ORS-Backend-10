# Base image (Java 11 runtime)
FROM eclipse-temurin:11-jre
 
# Working directory inside container
WORKDIR /app
 
# Copy jar file
COPY target/*.jar app.jar
 
# Expose Spring Boot port
EXPOSE 8080
 
# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]