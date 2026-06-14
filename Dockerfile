# Stage 1 : Build application
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /build

#copy pom xml and download dependanceies
COPY pom.xml .
RUN mvn dependency:go-offline

#copy source code
COPY src ./src

#package the application
RUN mvn clean package -DskipTests


# Stage 2: Run the application

FROM eclipse-temurin:17-jdk
WORKDIR /app

# copy the built JAR from the build stage
COPY --from=build /build/target/catalogue-management-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

