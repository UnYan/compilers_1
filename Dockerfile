FROM openjdk:12-alpine
COPY ./* ./src/
WORKDIR /src/
RUN javac -d ./output ./Main.java
WORKDIR /src/output