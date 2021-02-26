FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8086
ADD target/*.jar app2.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app2.jar" ]