# Use a base image with Maven and JDK 17 for the build stage
FROM maven:3.8.4-openjdk-17 AS build
#maven:3.6.0-jdk-8

WORKDIR /app

COPY pom.xml /app/pom.xml
COPY src /app/src

RUN mvn -f /app/pom.xml clean install -DskipTests=true

RUN mvn -f /app/pom.xml clean package -DskipTests=true

# Use a base image with just JDK 17 for the run stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/students-demo-0.0.1-SNAPSHOT.jar /app/students-demo.jar

EXPOSE 8080

CMD ["java", "-jar", "students-demo.jar"]
