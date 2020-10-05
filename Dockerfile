FROM openjdk:1.8.0_211-alpine
COPY ./* ./src/
WORKDIR /src/
RUN javac -d ./output ./Main.java
WORKDIR /src/output