FROM tomcat:10.1-jdk21-temurin

WORKDIR /usr/local/tomcat/webapps
# Create a setenv.sh file and configure Tomcat to use the PORT environment variable
RUN echo 'export CATALINA_OPTS="$CATALINA_OPTS -Dport.http.nonssl=$PORT"' > setenv.sh && \
    chmod +x setenv.sh

RUN rm -rf ./*
RUN rm -rf /usr/local/tomcat/webapps/*

RUN apt-get update && \
    apt-get install -y maven
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY ./target/CCODE.pattern.rest.war ROOT.war
COPY . /app
COPY ./conf/server.xml /usr/local/tomcat/conf/
WORKDIR /app

RUN --mount=type=cache,id=s/cbcd6488-98bc-4b7a-98d0-a1209477cc8e-/root/.m2,target=/root/.m2 \
    mvn -DskipTests clean install

EXPOSE $PORT

CMD ["catalina.sh", "run"]
