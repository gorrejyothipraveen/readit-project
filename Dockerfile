FROM eclipse-temurin:26-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew bootJar

EXPOSE 8080

CMD ["java", "-Dserver.port=${PORT:-8080}", "-jar", "build/libs/readit-0.0.1-SNAPSHOT.jar"]