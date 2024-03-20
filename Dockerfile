FROM openjdk:21-jdk
RUN echo "Start building coffeeshop image"
WORKDIR coffeeshop
COPY src/main/resources/application.properties application.properties
COPY build/libs/CoffeeShop-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.config.location=application.properties", "-jar","app.jar"]