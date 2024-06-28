# Use the official OpenJDK 21 image as the base
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the container
COPY . /app

# Build the application
RUN ./mvnw clean install -DskipTests

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Set the entry point to run the application
CMD ["java", "-jar", "target/blog-0.0.1-SNAPSHOT.jar"]
