FROM maven:3.8.4-openjdk-11-slim as build
RUN mkdir ManagerAccount
WORKDIR /ManagerAccount
COPY ./ ./
RUN mvn clean package spring-boot:repackage
RUN ls
RUN ls ./target

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /ManagerAccount/target/*.jar /jar-files/ManagerAccount.jar
WORKDIR /jar-files
RUN ls

EXPOSE 8081
CMD [ "java", "-jar", "-Dspring.profiles.active=prod", "ManagerAccount.jar" ]