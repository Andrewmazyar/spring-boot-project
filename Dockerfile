FROM openjdk:11-oracle
ADD target/spring-boot-project-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "docker-app.jar"]
