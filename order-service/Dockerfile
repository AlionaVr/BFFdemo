# build stage
FROM maven:3.9.1-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY user-service/pom.xml ./user-service/
COPY order-service/pom.xml ./order-service/
RUN mvn dependency:go-offline
COPY user-service/src ./user-service/src
COPY order-service/src ./order-service/src
RUN mvn clean package -pl order-service -am -DskipTests

# runtime stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/order-service/target/order-service-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]