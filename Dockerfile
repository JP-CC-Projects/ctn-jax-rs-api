# Use the specific Java 21 image based on Oracle Linux 8
FROM openjdk:21-oraclelinux8

# Set the working directory in the Docker container
WORKDIR /app

# Copy your Maven project files into the Docker container
COPY . /app


#RUN echo "Checking OS release information..." && \
#    cat /etc/os-release && \
#    echo "Listing potential package managers..." && \
#    ls /usr/bin/*apt* /usr/bin/*yum* /usr/bin/*dnf* || echo "No common package managers found" && \
#    echo "Checking for apt-get, yum, and dnf presence..." && \
#    which apt-get || echo "apt-get not found" && \
#    which yum || echo "yum not found" && \
#    which dnf || echo "dnf not found"


# Install Maven using apt (Debian/Ubuntu)
RUN microdnf update && \
    microdnf install maven && \
    microdnf clean all

# Build the application, skipping tests to speed up deployment
RUN mvn -DskipTests clean install

# Build the application, skipping tests to speed up deployment
RUN --mount=type=cache,id=s/b4d5caca-d379-4c7c-a78d-10725c38dd97-m2/repository,target=/root/.m2 \
    mvn -DskipTests clean install

# Expose the port your application uses
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "target/CCODEPatternRest-jar-with-dependencies.jar"]
