FROM openjdk:17
MAINTAINER jp92docker
ARG JAR_FILE=06-api-gateway/target/*.jar
COPY ${JAR_FILE} app.jar
CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar