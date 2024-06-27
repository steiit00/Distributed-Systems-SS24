# Use an official Maven image to build the application
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the Maven image
COPY --from=build /app/target/todo-*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8001

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
