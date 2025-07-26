
# Stage 1: Build the application
FROM maven:3.9.1-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy parent pom.xml and module pom.xml files
COPY pom.xml .
COPY user-service/pom.xml ./user-service/
COPY order-service/pom.xml ./order-service/

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY user-service/src ./user-service/src
COPY order-service/src ./order-service/src

# Build the user-service
RUN mvn clean package -pl user-service -am -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/user-service/target/user-service-1.0.0.jar app.jar

# Expose port and run
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]