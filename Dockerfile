    FROM openjdk:11.0.7-jre-slim-buster
    VOLUME /tmp
    COPY build/libs/*.jar app.jar
    ENTRYPOINT ["java", "-jar", "app.jar"]