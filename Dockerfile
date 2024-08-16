FROM maven:3.9.8-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# important! Copies directory over
COPY . .

# Build the WAR
RUN mvn -DskipTests clean package

# Create image WITH tomcat servlet
FROM tomcat:10.1-jdk21-temurin

# Set work dir
WORKDIR /usr/local/tomcat/webapps

# Remove remove all default files
RUN rm -rf ./*

# Copy the WAR from earlier step to /webapp
COPY --from=build /app/target/CCODE.pattern.rest.war ROOT.war

# Copy over configs files
COPY ./conf/server.xml /usr/local/tomcat/conf/

# Copy the entrypoint script to the container and make it executable
COPY ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Set environment variable for the port
ENV PORT=8080
EXPOSE 8080

# Set the entrypoint to the script that configures and starts Tomcat
ENTRYPOINT ["/entrypoint.sh"]

# Default command to run the Tomcat server
CMD ["catalina.sh", "run"]
