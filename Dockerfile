FROM maven:3.6.1-jdk-8 AS MVN_BUILD
MAINTAINER Ana

LABEL version="1.0" \
      description="This is an image for building sample broker app"

COPY . /code
RUN echo '{ "allow_root": true }' > rm -Rf /code/target && \
	cd /code/ && \
	chmod +x mvnw && \
    mvn clean package 

FROM openjdk:8-jre
COPY --from=MVN_BUILD /code/target/*.jar /broker.jar
RUN groupadd -r appuser && useradd -r -g appuser appuser
USER appuser

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","broker.jar"]
