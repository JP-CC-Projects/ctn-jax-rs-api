FROM tomcat:10.1-jdk21-temurin

# Define ARGs for build-time configuration
ARG RAILWAY_PUBLIC_DOMAIN
ARG RAILWAY_PRIVATE_DOMAIN
ARG RAILWAY_PROJECT_NAME
ARG RAILWAY_ENVIRONMENT_NAME
ARG RAILWAY_SERVICE_NAME
ARG RAILWAY_PROJECT_ID
ARG RAILWAY_ENVIRONMENT_ID
ARG RAILWAY_SERVICE_ID

# Set ENVs based on ARGs
ENV RAILWAY_PUBLIC_DOMAIN=$RAILWAY_PUBLIC_DOMAIN \
    RAILWAY_PRIVATE_DOMAIN=$RAILWAY_PRIVATE_DOMAIN \
    RAILWAY_PROJECT_NAME=$RAILWAY_PROJECT_NAME \
    RAILWAY_ENVIRONMENT_NAME=$RAILWAY_ENVIRONMENT_NAME \
    RAILWAY_SERVICE_NAME=$RAILWAY_SERVICE_NAME \
    RAILWAY_PROJECT_ID=$RAILWAY_PROJECT_ID \
    RAILWAY_ENVIRONMENT_ID=$RAILWAY_ENVIRONMENT_ID \
    RAILWAY_SERVICE_ID=$RAILWAY_SERVICE_ID

# Remove default web applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Install necessary tools
RUN apt-get update && \
    apt-get install -y maven

# Copy application WAR directly to webapps directory
COPY target/CCODE.pattern.rest.war /usr/local/tomcat/webapps/ROOT.war

WORKDIR /app

# Use cache mount for Maven dependencies to speed up builds
RUN --mount=type=cache,id=s/b4d5caca-d379-4c7c-a78d-10725c38dd97-/root/.m2/repository,target=/root/.m2/repository \
    mvn -DskipTests clean install

# Clean up apt cache and unnecessary lists
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

CMD ["catalina.sh", "run"]
