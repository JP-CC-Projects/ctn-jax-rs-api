#Run with this command:
#docker run -e SERVICE_ID=my-service-id -p 8080:8080 my-image

FROM tomcat:10.1-jdk21-temurin


ARG RAILWAY_PUBLIC_DOMAIN
ARG RAILWAY_PRIVATE_DOMAIN
ARG RAILWAY_PROJECT_NAME
ARG RAILWAY_ENVIRONMENT_NAME
ARG RAILWAY_SERVICE_NAME
ARG RAILWAY_PROJECT_ID
ARG RAILWAY_ENVIRONMENT_ID
ARG RAILWAY_SERVICE_ID

ENV RAILWAY_PUBLIC_DOMAIN=$RAILWAY_PUBLIC_DOMAIN \
    RAILWAY_PRIVATE_DOMAIN=$RAILWAY_PRIVATE_DOMAIN \
    RAILWAY_PROJECT_NAME=$RAILWAY_PROJECT_NAME \
    RAILWAY_ENVIRONMENT_NAME=$RAILWAY_ENVIRONMENT_NAME \
    RAILWAY_SERVICE_NAME=$RAILWAY_SERVICE_NAME \
    RAILWAY_PROJECT_ID=$RAILWAY_PROJECT_ID \
    RAILWAY_ENVIRONMENT_ID=$RAILWAY_ENVIRONMENT_ID \
    RAILWAY_SERVICE_ID=$RAILWAY_SERVICE_ID

# Remove the default web applications deployed with Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

RUN echo $RAILWAY_SERVICE_NAME

RUN apt-get update && \
    apt-get install -y maven

RUN mvn clean install

RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY . /app

WORKDIR /app

COPY target/CCODE.pattern.rest.war /usr/local/tomcat/webapps/ROOT.war

RUN --mount=type=cache,id=s/b4d5caca-d379-4c7c-a78d-10725c38dd97-/root/.m2,target=/root/.m2 \
    mvn -DskipTests clean install

CMD ["catalina.sh", "run"]