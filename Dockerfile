FROM openjdk:17-alpine
WORKDIR /app
LABEL maintainer="krya"

# If your application has dependencies to be installed, uncomment and use the following lines
# RUN apk add --no-cache maven
# COPY pom.xml .
# RUN mvn dependency:go-offline

# Copy the application code
COPY . .

# Build the application (if needed)
# RUN mvn package

# Copy the JAR file
COPY ./target/demo-spring-boot-docker-0.0.1-SNAPSHOT.jar demo-spring-boot-docker.jar

ENTRYPOINT ["java", "-jar", "demo-spring-boot-docker.jar"]
