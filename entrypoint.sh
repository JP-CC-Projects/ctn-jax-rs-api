#!/bin/bash
# Dynamic replacement if server.xml still uses a placeholder
sed -i 's/\${PORT}/'"$PORT"'/g' /usr/local/tomcat/conf/server.xml

# Debugging: Echo the port being used (optional but helpful for logs)
echo "Starting Tomcat on PORT: $PORT"

# Start the Tomcat server
catalina.sh run