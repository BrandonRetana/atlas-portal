FROM ubuntu:latest

# Install Java 11
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

# Install Maven
RUN apt-get install -y maven

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application with Maven
RUN mvn package

# Set the default command to run when the container starts
CMD tail -f /dev/null
