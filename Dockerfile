FROM openjdk:8
EXPOSE 8085
ADD target/ebug-tracker-docker.jar  ebug-tracker-docker.jar
ENTRYPOINT ["java","-jar","/ebug-tracker-docker.jar"]