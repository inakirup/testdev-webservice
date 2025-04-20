# Stage 1: Build with Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only the POM file first to cache dependencies
COPY springboot-backend/pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

# Copy source code
COPY springboot-backend/src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run with JDK only
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]