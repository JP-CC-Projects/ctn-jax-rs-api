# Use the specific Java 21 image based on Oracle Linux 8
FROM openjdk:21-oraclelinux8

# Set the working directory in the Docker container
WORKDIR /app

# Copy your Maven project files into the Docker container
COPY . /app

# Install Maven and other necessary tools
RUN yum install -y maven && yum clean all

# Build the application, skipping tests to speed up deployment
RUN --mount=type=cache,id=s/<service-id>-maven,target=/root/.m2 \
    mvn -DskipTests clean install

# Expose the port your application uses
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "target/your-application.jar"]
