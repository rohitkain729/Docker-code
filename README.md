services:
  userregistrationsystem:
    image: userregistrationsystem
    container_name: registration
    build: .
    ports:
      - '8080:8080'
    environment:
      DB_USERNAME: rohit
      DB_PASSWORD: admin
      DB_URL: jdbc:mysql://mysqldb:3306/users-mysql
    depends_on:
      - mysqldb

  mysqldb:
    image: mysql:8.4
    container_name: mysql_db
    ports:
      - "3307:3306"
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_DATABASE: users-mysql
      MYSQL_USER: rohit
      MYSQL_PASSWORD: admin
    volumes:
      - mysql-data:/var/lib/mysql

volumes:
  mysql-data:


  FROM eclipse-temurin:17-jre
ARG JAR_FILE=target/user-registration-system.jar
ADD ${JAR_FILE} userregistration.jar
ENTRYPOINT ["java","-jar","/userregistration.jar"]


spring:
  application:
    name: userregistrationsystem

  datasource:
      url: ${DB_URL:jdbc:mysql://localhost:3307/users-mysql}
      username: ${DB_USERNAME:rohit}
      password: ${DB_PASSWORD:admin}
      driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
