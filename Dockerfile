FROM openjdk:17-oracle
EXPOSE 8082
COPY target/springbootLoginAndRegister.jar springbootLoginAndRegister.jar
ENTRYPOINT ["java","-jar","/springbootLoginAndRegister.jar"]