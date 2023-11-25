# https://docs.docker.com/build/building/multi-stage/#use-multi-stage-builds

# First Stage
#FROM arm64v8/eclipse-temurin:21-jdk-ubi9-minimal as builder
# Use alpine 3.18 as the base image
FROM alpine:3.18

# Set environment variables for configuration
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk
ENV MAVEN_HOME=/usr/share/maven

# Install JDK 11 and maven
RUN apk add --no-cache openjdk21 maven

# Set default values for environment variables
ENV PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Add labels for better maintainability
LABEL maintainer="Your Name <your.email@example.com>"
LABEL version="1.0"
LABEL description="Dockerfile for JDK 11 and Maven"

# Set the working directory
WORKDIR /app

# Copy the application code to the container
COPY . /app

# Run any necessary commands
RUN mvn clean install

# Set the entrypoint command
CMD ["java", "-jar", "target/myapp.jar"]

# Second Stage
FROM arm64v8/eclipse-temurin:21-jdk-ubi9-minimal
EXPOSE 8080
COPY --from=builder /src/build/libs/spring-boot-app*  /app/spring-boot.jar
ENTRYPOINT ["java","-Duser.timezone=GMT+1","-jar","--enable-preview", "/app/spring-boot.jar"]
