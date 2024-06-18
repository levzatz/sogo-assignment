FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY --from=build /app/target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/api-gateway.jar"]