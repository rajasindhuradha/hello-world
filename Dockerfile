FROM tomcat:8-jre11

COPY ./target/hello-world-*.war /usr/local/tomcat/webapps/hello-world.war