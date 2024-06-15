FROM openjdk:17-jdk-slim
# Create a working directory for the application
WORKDIR /app
# Copy the JAR file from the build context
COPY target/*.jar app.jar
# Expose the port your Spring Boot application listens on (replace 8080 with your actual port)
EXPOSE 8081
# Set the default command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
