FROM openjdk:11
COPY target/*.jar /
CMD java -jar /*.jar