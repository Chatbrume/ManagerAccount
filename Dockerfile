FROM maven:3.8.4-openjdk-11-slim as build
RUN mkdir ManageAccount
WORKDIR /ManageAccount
COPY ./ ./
RUN mvn clean package spring-boot:repackage
RUN ls
RUN ls ./target

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /ManageAccount/target/*.jar /jar-files/ManageAccount.jar
WORKDIR /jar-files

EXPOSE 8081
CMD [ "java", "-jar", "-Dspring.profiles.active=prod", "ManageAccount.jar" ]