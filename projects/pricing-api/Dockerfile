FROM alpine
RUN apk update && apk add openjdk8-jre-base
WORKDIR /app
COPY ./target/pricing-api.jar ./
ENTRYPOINT ["java","-jar","pricing-api.jar"]
EXPOSE 80