FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y curl
VOLUME /tmp
COPY --from=build /app/target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/eureka-server.jar"]