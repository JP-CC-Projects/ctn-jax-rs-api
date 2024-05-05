# Use the specific Java 21 image based on Oracle Linux 8
FROM openjdk:21-oraclelinux8

# Set the working directory in the Docker container
WORKDIR /app

# Copy your Maven project files into the Docker container
COPY . /app

# Install Maven using apt (Debian/Ubuntu)
RUN dnf -y update && \
    dnf -y install maven && \
    dnf clean all

# Build the application, skipping tests to speed up deployment
RUN mvn -DskipTests clean install

# Build the application, skipping tests to speed up deployment
RUN --mount=type=cache,id=s/b4d5caca-d379-4c7c-a78d-10725c38dd97-m2/repository,target=/root/.m2 \
    mvn -DskipTests clean install

# Expose the port your application uses
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "target/CCODEPatternRest-jar-with-dependencies.jar"]
