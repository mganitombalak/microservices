FROM alpine
RUN apk update && apk add openjdk8-jre-base
WORKDIR /app
COPY ./target/eureka-server.jar ./
ENTRYPOINT ["java","-jar","eureka-server.jar"]
EXPOSE 8761

