FROM openjdk:17-jdk-alpine
ADD target/*.jar groupe3.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/groupe3.jar"]
VOLUME /main-app
LABEL key="groupe3aw"