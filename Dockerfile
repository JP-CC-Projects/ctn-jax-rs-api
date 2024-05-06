#Run with this command:
#docker run -e SERVICE_ID=my-service-id -p 8080:8080 my-image

# Use the specific Java 21 image based on Oracle Linux 8
FROM tomcat:10.1-jdk21-temurin

# Declare SERVICE_ID build argument, pulled from application.properties or the env
ARG RAILWAY_SERVICE_ID

# Remove the default web applications deployed with Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into the Docker container into Tomcat's webapps directory
COPY target/CCODE.pattern.rest.war /usr/local/tomcat/webapps/ROOT.war

# Set the working directory in the Docker container
WORKDIR /app

# Copy your Maven project files into the Docker container
COPY . /app

# Determines what installation tool is
#RUN echo "Checking OS release information..." && \
#    cat /etc/os-release && \
#    echo "Listing potential package managers..." && \
#    ls /usr/bin/*apt* /usr/bin/*yum* /usr/bin/*dnf* || echo "No common package managers found" && \
#    echo "Checking for apt-get, yum, and dnf presence..." && \
#    which apt-get || echo "apt-get not found" && \
#    which yum || echo "yum not found" && \
#    which dnf || echo "dnf not found"

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Build the application, skipping tests to speed up deployment
RUN --mount=type=cache,id=s/${RAILWAY_SERVICE_ID}-maven,target=/root/.m2 \
    mvn -DskipTests clean install

# Expose the port your application uses
EXPOSE 8080

# Command to run your application
CMD ["catalina.sh", "run"]