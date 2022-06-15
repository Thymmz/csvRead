FROM openjdk:17
ADD target/*.jar springboot-fqd-app.jar
ENTRYPOINT ["java","-jar","/springboot-fqd-app.jar"]