
FROM openjdk:8-jdk-alpine AS base

VOLUME /tmp



FROM base AS api

COPY . /usr/src/example

EXPOSE 8083

ENTRYPOINT ["java","-jar","/usr/src/example/karate-test-prime-example-1.0-SNAPSHOT.jar"]



FROM base AS e2e

#install Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-6.0.1-bin.zip \
    && unzip gradle-6.0.1-bin.zip -d /opt \
    && rm gradle-6.0.1-bin.zip

# Set Gradle in the environment variables
ENV GRADLE_HOME /opt/gradle-6.0.1
ENV PATH $PATH:/opt/gradle-6.0.1/bin:/usr/src/example

COPY . /usr/src/example

WORKDIR /usr/src/example
