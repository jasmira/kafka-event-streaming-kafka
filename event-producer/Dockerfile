FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]