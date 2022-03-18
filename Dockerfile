FROM maven:3.8.4-openjdk-17
WORKDIR /app-java
COPY . .
ENTRYPOINT mvn test