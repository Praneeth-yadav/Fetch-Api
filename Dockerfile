FROM openjdk:22-slim-bullseye
LABEL maintainer="praneeth"
ADD ./target/api-0.0.1-SNAPSHOT.jar springboot-fetch-api.jar
ENTRYPOINT ["java","-jar","springboot-fetch-api.jar"]