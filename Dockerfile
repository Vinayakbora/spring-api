FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/bajajmall-api.jar .
EXPOSE 8080
ENTRYPOINT [ "java","-jar","bajajmall-api.jar"]