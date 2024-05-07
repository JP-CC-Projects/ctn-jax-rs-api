# Use an official Tomcat base image with JDK included
FROM tomcat:10.1-jdk21-temurin

# Set the working directory to Tomcat's webapp directory
WORKDIR /usr/local/tomcat/webapps

# Remove default web applications included with Tomcat
RUN rm -rf ./*

# Install Maven for building the application (if necessary)
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy the built WAR file to the webapp directory to deploy it
COPY ./target/CCODE.pattern.rest.war ROOT.war

# Set the working directory to the root application directory
WORKDIR /app

# Copy the application source and other necessary files
COPY . .

# Copy the server configuration files
COPY ./conf/server.xml /usr/local/tomcat/conf/

# Copy the entrypoint script to the container and make it executable
COPY ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Specify the port environment variable that will be provided by Railway at runtime
ARG PORT=8080
ENV PORT=${PORT}
EXPOSE $PORT

# Specify any other necessary build-time environment variables
ARG RAILWAY_SERVICE_NAME

# Use Railway's cache mounts feature if needed
# RUN --mount=type=cache,id=s/<service id>-/root/cache/maven,target=/root/.m2 ...

# Set the entrypoint to the script that configures and starts Tomcat
ENTRYPOINT ["/entrypoint.sh"]

# Default command to run the Tomcat server
CMD ["catalina.sh", "run"]
