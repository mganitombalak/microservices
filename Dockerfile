FROM alpine
RUN apk update
RUN apk add openjdk8-jre-base
WORKDIR /app
COPY ./target/product-api.jar ./
#ADD
ENTRYPOINT ["java","-jar","product-api.jar"]
CMD["-DXsm=256"]
CMD["-DXsm=512"]
