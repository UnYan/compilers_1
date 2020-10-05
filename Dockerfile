FROM openjdk:13
WORKDIR /src/
COPY ./* ./
RUN javac Main.java