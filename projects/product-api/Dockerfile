FROM alpine
RUN apk update && apk add openjdk8-jre-base
WORKDIR /app
COPY ./target/product-api.jar ./
ENTRYPOINT ["java","-jar","product-api.jar"]
EXPOSE 80