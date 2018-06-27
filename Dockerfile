<<<<<<< HEAD

#IMAGE: Get the base image for Liberty
FROM websphere-liberty:beta

#BINARIES: Add in all necessary application binaries
RUN rm -rf /opt/ibm/wlp
COPY wlp-beta-2018.6.0.0.zip /tmp
RUN unzip -o /tmp/wlp-beta-2018.6.0.0.zip -d /opt/ibm/
COPY liberty/server.xml /opt/ibm/wlp/usr/servers/defaultServer/
RUN mkdir /opt/ibm/wlp/usr/servers/defaultServer/apps
COPY target/sprint-poc-0.1.0.jar /opt/ibm/wlp/usr/servers/defaultServer/apps
#RUN mkdir /config/lib
#COPY ./binary/lib/* /config/lib/

#FEATURES: Install any features that are required
RUN /opt/ibm/wlp/bin/installUtility install  --acceptLicense \
	springBoot-2.0 \
	websocket-1.1 \
	servlet-3.1; exit 0
=======
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/order-mgt-0.0.1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
>>>>>>> 5cf511885910850fe7a03dcf83b4dcc26149bd80
