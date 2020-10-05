FROM openjdk:12
WORKDIR /src/
COPY ./* ./
RUN javac Main.java