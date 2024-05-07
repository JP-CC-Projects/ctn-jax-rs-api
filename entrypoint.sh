#!/bin/bash
# Replace the placeholder in server.xml with the actual PORT variable
sed -i 's/{{PORT}}/'"$PORT"'/g' /usr/local/tomcat/conf/server.xml
# Run Tomcat
catalina.sh run