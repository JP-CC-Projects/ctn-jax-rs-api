FROM tomcat:10.1-jdk21-temurin

WORKDIR /usr/local/tomcat/webapps
#ARG RAILWAY_SERVICE_NAME
#ENV RAILWAY_SERVICE_NAME=$RAILWAY_SERVICE_NAME
RUN rm -rf ./*
RUN rm -rf /usr/local/tomcat/webapps/*
#RUN echo $RAILWAY_SERVICE_NAME


RUN apt-get update && \
    apt-get install -y maven

COPY ./target/CCODE.pattern.rest.war ROOT.war
COPY . /app
WORKDIR /app

RUN --mount=type=cache,id=s/cbcd6488-98bc-4b7a-98d0-a1209477cc8e-/root/.m2,target=/root/.m2 \
    mvn -DskipTests clean install
#
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

CMD ["catalina.sh", "run"]
