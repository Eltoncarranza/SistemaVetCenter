FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/PRODUCTO-Service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9007
ENTRYPOINT ["java", "-jar", "app.jar"]