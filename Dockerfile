FROM maven
COPY src/main/resources/files/ /var/lib/csvdata
ADD target/*.jar springboot-fqd-app.jar
ENTRYPOINT ["java","-jar","/springboot-fqd-app.jar", "spring.config.location=/etc/config/application.properties"]