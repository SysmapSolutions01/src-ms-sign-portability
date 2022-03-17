FROM openjdk:11.0.14.1-oracle
WORKDIR /app
COPY ./target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]