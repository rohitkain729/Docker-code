FROM eclipse-temurin:17-jre
ARG JAR_FILE=target/user-registration-system.jar
ADD ${JAR_FILE} userregistration.jar
ENTRYPOINT ["java","-jar","/userregistration.jar"]
