# Start from a base image with Java
FROM openjdk:11-jdk-slim

# Create directory inside container
WORKDIR /app

# Copy the jar file
COPY target/studsluzba_server-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]