FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/fit-track-1.0.0.jar fit-track-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "fit-track-0.0.1-SNAPSHOT.jar"]
