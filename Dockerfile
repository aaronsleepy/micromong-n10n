FROM openjdk:11.0.7-jre-slim-buster
VOLUME /tmp
COPY run.sh .
COPY build/libs/*.jar app.jar
ENTRYPOINT ["sh", "/run.sh"]