FROM alpine
RUN apk update && apk add openjdk8-jre-base
RUN apk add git
WORKDIR /opt/config-repo
RUN git init && \
    git config --global user.email "mgani.tombalak@aerotivelabs.com" && \
    git config --global user.name "mgani.tombalak"
COPY *.properties ./
RUN git add --all && git commit -m "Initial Config"
WORKDIR /app
COPY ./config-server/target/config-server.jar ./
ENTRYPOINT ["java","-jar","config-server.jar"]
VOLUME /opt/config-repo
EXPOSE 8888
