FROM maven:3.8.6-eclipse-temurin-17-alpine

WORKDIR /buscapatas

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn install -Dmaven.test.skip=true

ENTRYPOINT ["./entrypoint.sh"]