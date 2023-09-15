FROM amazoncorretto:17-alpine3.18-jdk as build

WORKDIR /app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests

FROM amazoncorretto:17-alpine3.18

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/target/almacen.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
