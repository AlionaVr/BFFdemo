FROM maven:3.9.1-eclipse-temurin-17 AS builder
WORKDIR /app

COPY . .

RUN mvn clean package -pl user-service -am -DskipTests

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY --from=builder /app/user-service/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]