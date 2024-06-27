# Use a base image with OpenJDK Java 17 installed
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/job-portal-web-application-0.0.1-SNAPSHOT.jar /app

# Specify the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "job-portal-web-application-0.0.1-SNAPSHOT.jar"]