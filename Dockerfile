FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Assignment2-0.0.1-SNAPSHOT.jar Assignment2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Assignment2.jar"]