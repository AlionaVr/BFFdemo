FROM maven:3.9.1-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml .
COPY common/pom.xml ./common/
COPY order-service/pom.xml ./order-service/
COPY site-bff/pom.xml ./site-bff/
COPY user-service/pom.xml ./user-service/

RUN mvn install -pl :common -am -DskipTests &&\
    mvn -B dependency:go-offline

COPY . .

RUN mvn -B -f pom.xml clean &&\
    mvn -B -f pom.xml package -DskipTests

FROM eclipse-temurin:17-jdk-jammy AS user-service
WORKDIR /app
COPY --from=builder /app/user-service/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]

FROM eclipse-temurin:17-jdk-jammy AS order-service
WORKDIR /app
COPY --from=builder /app/order-service/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]

FROM eclipse-temurin:17-jdk-jammy AS site-bff
WORKDIR /app
COPY --from=builder /app/site-bff/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
