FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/CLIENTE-Service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "app.jar"]