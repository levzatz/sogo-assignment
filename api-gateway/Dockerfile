FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/api-gateway.jar"]