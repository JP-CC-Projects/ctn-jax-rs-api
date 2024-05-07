#!/bin/bash
sed -i 's/\${PORT}/'"$PORT"'/g' /usr/local/tomcat/conf/server.xml
# Run Tomcat
catalina.sh run
