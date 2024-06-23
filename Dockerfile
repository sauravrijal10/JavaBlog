# # Use the official OpenJDK 21 image as the base
# FROM openjdk:21-jdk

# # Set the working directory inside the container
# WORKDIR /app

# # Copy the project files to the container
# COPY . /app

# # Build the application
# RUN ./mvnw clean package -DskipTests


# # Expose the port on which your Spring Boot application runs
# EXPOSE 8080

# # Set the entry point to run the application
# CMD ["java", "-jar", "target/blog-0.0.1-SNAPSHOT.jar"]

# Use the official OpenJDK 21 image as the base
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and the project files to the container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Ensure the Maven wrapper script has execution permissions
RUN chmod +x ./mvnw

# Download and install the dependencies (this will cache them in Docker layer)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the project files
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Set the entry point to run the application
CMD ["java", "-jar", "target/blog-0.0.1-SNAPSHOT.jar"]
