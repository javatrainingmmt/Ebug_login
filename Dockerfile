FROM openjdk:11
EXPOSE 8086
ADD target/ebug-tracker-docker.jar  ebug-tracker-docker.jar
ENTRYPOINT ["java","-jar","/ebug-tracker-docker.jar"]